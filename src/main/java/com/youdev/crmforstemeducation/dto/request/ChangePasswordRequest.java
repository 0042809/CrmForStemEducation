package com.youdev.crmforstemeducation.dto.request;

import lombok.Data;
@Data
public class ChangePasswordRequest {
    @NotBlank(message = "Current password is required")
    private String currentPassword;
    @NotBlank(message = "New password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String newPassword;
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
}
