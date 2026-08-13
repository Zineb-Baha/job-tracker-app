package online.hire.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import online.hire.auth.dto.LoginRequest;
import online.hire.auth.dto.SignupRequest;
import online.hire.user.User;
import online.hire.user.UserRepository;

@Service
public class AuthService {
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void signup(SignupRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setEmail(request.email());
        user.setPasswordHash(
            passwordEncoder.encode(request.password())
        );
        user.setRole(request.role());

        userRepository.save(user);
    }
    
    public String login(LoginRequest request) {

        User user = userRepository
            .findByEmail(request.email())
            .orElseThrow(() ->
                new RuntimeException("Invalid email or password")
            );

        if (!passwordEncoder.matches(
                request.password(),
                user.getPasswordHash())) {

            throw new RuntimeException("Invalid email or password");
        }

        return jwtService.generateToken(user);
    }

}
