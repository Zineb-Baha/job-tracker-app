package online.hire.candidateProfile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateProfileRepository extends JpaRepository<CandidateProfile, Long> {
	
Optional<CandidateProfile> findByUserId(Long id);
	
}
