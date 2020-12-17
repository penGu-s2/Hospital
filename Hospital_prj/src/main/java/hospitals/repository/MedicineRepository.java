package hospitals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hospitals.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	
}