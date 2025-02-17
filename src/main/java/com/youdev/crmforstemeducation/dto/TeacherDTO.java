package com.youdev.crmforstemeducation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherDTO extends BaseDTO {
    private Long userId;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @Min(value = 0, message = "Experience cannot be negative")
    private Integer experience;

    private String qualification;
    private String status;
    private Set<Long> subjectIds;
}
