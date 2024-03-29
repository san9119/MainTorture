package com.project.tasklist.repo;

import com.project.tasklist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT s FROM task s where s.title = ?1")
    Optional<Task> findTaskByTitle(String title);
}
