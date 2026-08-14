package online.hire.resume;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import online.hire.candidateProfile.CandidateProfile;

@Entity
@Table(name = "resume")
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(
	    name = "candidate_profile_id"
	)
	private CandidateProfile candidateProfile;

}
