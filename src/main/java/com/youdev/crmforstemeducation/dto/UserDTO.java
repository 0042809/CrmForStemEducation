package com.youdev.crmforstemeducation.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.youdev.crmforstemeducation.model.enums.Role;
import jakarta.validation.constraints.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotNull(message = "Role is required")
    private Role role;

    private String phoneNumber;
    private boolean active;
}