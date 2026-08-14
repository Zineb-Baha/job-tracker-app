package online.hire.candidateProfile.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateProfileUpdateRequest {

	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String address;
	
	private String degree;
	
	private String headline;
	
	private String summary;
	
	private String profilePictureUrl;

}
