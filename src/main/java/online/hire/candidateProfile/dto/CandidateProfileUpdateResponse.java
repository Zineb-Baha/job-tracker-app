package online.hire.candidateProfile.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateProfileUpdateResponse {
	
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String address;
	
	private String degree;
	
	private String headline;
	
	private String summary;
	
	private String profilePictureUrl;

}
