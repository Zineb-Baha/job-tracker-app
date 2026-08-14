package online.hire.candidateProfile;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import online.hire.resume.Resume;
import online.hire.user.User;

@Entity
@Table(name = "candidate_profiles")
@Getter
@Setter
public class CandidateProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	private String phoneNumber;
	
	private String address;
	
	private String degree;
	
	private String headline;
	
	private String summary;
	
	private String profilePictureUrl;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private User user;
	
	@OneToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@OneToMany(mappedBy = "candidateProfile")
	private List<Education> educationList;
	
	@OneToMany(mappedBy = "candidateProfile")
	private List<Skills> skillsList;
	
	@OneToMany(mappedBy = "candidateProfile")
	private List<Experience> experienceList;
}
