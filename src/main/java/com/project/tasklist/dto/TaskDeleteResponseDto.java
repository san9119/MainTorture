package com.project.tasklist.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskDeleteResponseDto {
    private long Id;
}
