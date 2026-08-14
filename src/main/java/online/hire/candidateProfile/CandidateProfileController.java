package online.hire.candidateProfile;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import online.hire.candidateProfile.dto.CandidateProfileUpdateRequest;
import online.hire.candidateProfile.dto.CandidateProfileUpdateResponse;

@RestController
@RequestMapping("/api/candidate-profiles")
public class CandidateProfileController {
	
	private final CandidateProfileService candidateProfileService;
	
	public CandidateProfileController(CandidateProfileService candidateProfileService) {
		this.candidateProfileService = candidateProfileService;
	}
	
	@PutMapping("/{userId}")
	public CandidateProfileUpdateResponse updateCandidateProfile(@PathVariable Long userId, @RequestBody CandidateProfileUpdateRequest request) {
		return candidateProfileService.updateCandidateProfile(userId, request);
	}
	
	@PostMapping
	public CandidateProfileUpdateResponse createCandidateProfile(@RequestParam("userId") Long userId, @RequestBody CandidateProfileUpdateRequest request) {
		 System.out.println("firstName = " + request.getFirstName());
		    System.out.println("lastName = " + request.getLastName());
		return candidateProfileService.createCandidateProfile(userId, request);
	}

}
