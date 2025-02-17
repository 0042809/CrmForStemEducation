package com.youdev.crmforstemeducation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class TestResultDTO extends BaseDTO {
    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Test ID is required")
    private Long testId;

    @Min(value = 0, message = "Score cannot be negative")
    private Integer score;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private String feedback;
}