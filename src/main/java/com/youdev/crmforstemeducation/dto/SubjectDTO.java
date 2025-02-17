package com.youdev.crmforstemeducation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class SubjectDTO extends BaseDTO {
    @NotBlank(message = "Subject name is required")
    private String name;

    private String description;
}
