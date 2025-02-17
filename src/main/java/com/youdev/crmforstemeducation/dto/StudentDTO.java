package com.youdev.crmforstemeducation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentDTO extends BaseDTO {
    private Long userId;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Invalid phone number format")
    private String phoneNumber;

    private String address;

    @NotBlank(message = "Parent contact is required")
    private String parentContact;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    private Long groupId;
    private String status;
}