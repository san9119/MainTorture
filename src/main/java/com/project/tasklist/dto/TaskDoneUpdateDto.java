package com.project.tasklist.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaskDoneUpdateDto {
    private Boolean done;
}
