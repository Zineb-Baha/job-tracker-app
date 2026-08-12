package online.hire.auth.dto;

import online.hire.user.Role;

public record SignupRequest(
        String email,
        String password,
        Role role
) {}