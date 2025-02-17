package com.youdev.crmforstemeducation.dto;

import com.youdev.crmforstemeducation.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class AttendanceDTO extends BaseDTO {
    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Lesson ID is required")
    private Long lessonId;

    @NotNull(message = "Status is required")
    private String status;

    private String comment;
}
