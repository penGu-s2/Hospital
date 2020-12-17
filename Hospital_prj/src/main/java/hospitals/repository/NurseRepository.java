package hospitals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hospitals.model.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
	
}
