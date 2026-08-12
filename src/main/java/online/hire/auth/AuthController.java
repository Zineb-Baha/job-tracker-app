package online.hire.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.hire.auth.dto.AuthResponse;
import online.hire.auth.dto.LoginRequest;
import online.hire.auth.dto.SignupRequest;

@RestController
@RequestMapping("/api/users/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	 @PostMapping("/signup")
	    public ResponseEntity<?> signup(
	            @RequestBody SignupRequest request) {

	        authService.signup(request);

	        return ResponseEntity.ok("User created");
	    }
	 
	 @PostMapping("/login")
	 public ResponseEntity<AuthResponse> login(
	         @RequestBody LoginRequest request) {

	     String token = authService.login(request);

	     return ResponseEntity.ok(
	         new AuthResponse(token)
	     );
	 }
	 

}
