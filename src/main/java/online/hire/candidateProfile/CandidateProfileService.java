package online.hire.candidateProfile;

import java.util.Optional;

import org.springframework.stereotype.Service;

import online.hire.candidateProfile.dto.CandidateProfileUpdateRequest;
import online.hire.candidateProfile.dto.CandidateProfileUpdateResponse;
import online.hire.user.User;
import online.hire.user.UserRepository;

@Service
public class CandidateProfileService {
	
	private CandidateProfileRepository candidateProfileRepository;
	private UserRepository userRepository;
	CandidateProfileService(CandidateProfileRepository candidateProfileRepository, UserRepository userRepository) {
		this.candidateProfileRepository = candidateProfileRepository;
		this.userRepository = userRepository;
	}
	
	public CandidateProfile getCandidateProfile(Long id) {
		// Implement the logic to retrieve the candidate profile by ID
		return null; // Placeholder return statement
	}
	
	public CandidateProfileUpdateResponse updateCandidateProfile(Long userId, CandidateProfileUpdateRequest request) {
		
		
		Optional<CandidateProfile> optionalProfile = candidateProfileRepository.findByUserId(userId);
		System.out.println("Updating candidate profile for userId: " + userId+ " : | profile exists: " + optionalProfile.isPresent());
		optionalProfile.ifPresent(profile -> {
			profile.setFirstName(request.getFirstName());
			profile.setLastName(request.getLastName());
			profile.setPhoneNumber(request.getPhoneNumber());
			profile.setAddress(request.getAddress());
			profile.setDegree(request.getDegree());
			profile.setHeadline(request.getHeadline());
			profile.setSummary(request.getSummary());
			profile.setProfilePictureUrl(request.getProfilePictureUrl());
			candidateProfileRepository.save(profile);
		});
		
		return optionalProfile.map(profile -> new CandidateProfileUpdateResponse(
				profile.getId(),
				profile.getFirstName(),
				profile.getLastName(),
				profile.getPhoneNumber(),
				profile.getAddress(),
				profile.getDegree(),
				profile.getHeadline(),
				profile.getSummary(),
				profile.getProfilePictureUrl()
		)).orElse(null);
	}

	public CandidateProfileUpdateResponse createCandidateProfile(Long userId, CandidateProfileUpdateRequest request) {
		 if (candidateProfileRepository.findByUserId(userId).isPresent()) {
		        throw new RuntimeException(
		                "Candidate profile already exists");
		    }
		CandidateProfile profile = new CandidateProfile();
		Optional<User> optionalUser = userRepository.findById(userId);
		profile.setUser(optionalUser.orElseThrow(() -> new RuntimeException("User not found")));
			profile.setFirstName(request.getFirstName());
			profile.setLastName(request.getLastName());
			profile.setPhoneNumber(request.getPhoneNumber());
			profile.setAddress(request.getAddress());
			profile.setDegree(request.getDegree());
			profile.setHeadline(request.getHeadline());
			profile.setSummary(request.getSummary());
			profile.setProfilePictureUrl(request.getProfilePictureUrl());
			candidateProfileRepository.save(profile);
		
		
		return new CandidateProfileUpdateResponse(
				profile.getId(),
				profile.getFirstName(),
				profile.getLastName(),
				profile.getPhoneNumber(),
				profile.getAddress(),
				profile.getDegree(),
				profile.getHeadline(),
				profile.getSummary(),
				profile.getProfilePictureUrl());
	}

}
