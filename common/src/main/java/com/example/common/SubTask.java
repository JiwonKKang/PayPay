package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubTask {
    private Long membershipId;
    private String subTaskName;
    private TaskType taskType; // "banking", "membership"
    private TaskStatus status; // "success", "fail", "ready"
}


