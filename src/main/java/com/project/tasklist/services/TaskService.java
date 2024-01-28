package com.project.tasklist.services;

import com.project.tasklist.config.mapper.TaskMapper;
import com.project.tasklist.exceptions.TaskByIdException;
import com.project.tasklist.exceptions.TaskCreateException;
import com.project.tasklist.models.Task;
import com.project.tasklist.repo.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<Task> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    public void addNewTask(Task task) {
        if(task.getTitle().isEmpty()){
            throw new TaskCreateException("Задача должна иметь заголовк");
        }

        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(() ->new TaskByIdException(
                "Задача с id = "+ id +" не существует"
        ));
        taskRepository.deleteById(id);

    }

    @Transactional
    public void updateTask(Long taskId, boolean done) {
        Task updatedTask = findTaskById(taskId);
        updatedTask.setDone(done);
        taskRepository.save(updatedTask);
    }

    public Task findTaskById(long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() ->new TaskByIdException(
                "По ID - "+ taskId +"ниче нет"
        ));
    }
}
