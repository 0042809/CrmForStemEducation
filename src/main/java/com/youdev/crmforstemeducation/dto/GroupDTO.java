package com.youdev.crmforstemeducation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class GroupDTO extends BaseDTO {
    @NotBlank(message = "Group name is required")
    private String name;

    @NotNull(message = "Teacher ID is required")
    private Long teacherId;

    @NotNull(message = "Subject ID is required")
    private Long subjectId;

    @Min(value = 1, message = "Maximum students must be at least 1")
    private Integer maxStudents;

    private String status;
}