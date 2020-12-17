package hospitals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospitals.model.Nurse;
import hospitals.repository.NurseRepository;

@Service
public class NurseService {
@Autowired

private NurseRepository nurseRepository;

public List<Nurse> getNurse(){
	return nurseRepository.findAll();
}
public void addNurse(Nurse nurse) {
	nurseRepository.save(nurse);
}
public void updateNurse(Nurse nurse) {
	nurseRepository.save(nurse);
}
public void deleteNurse(long id) {
	nurseRepository.deleteById(id);
}
}
