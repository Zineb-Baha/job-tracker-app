package online.hire.auth.dto;

public record LoginRequest(
        String email,
        String password
) {}