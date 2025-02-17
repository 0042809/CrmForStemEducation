package com.youdev.crmforstemeducation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class TestDTO extends BaseDTO {
    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Subject ID is required")
    private Long subjectId;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;

    @NotNull(message = "Maximum score is required")
    @Min(value = 1, message = "Maximum score must be at least 1")
    private Integer maxScore;

    @NotNull(message = "Passing score is required")
    @Min(value = 1, message = "Passing score must be at least 1")
    private Integer passingScore;

    @Future(message = "Due date must be in the future")
    private LocalDateTime dueDate;

    private String status;
}