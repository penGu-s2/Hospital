package hospitals.service;

import java.util.List;

import hospitals.model.Doctor;

public interface DoctorService {
	List<Doctor> getAllDoctors();
	void saveDoctor(Doctor doctor);
	Doctor getDoctorById(long id);
	void deleteDoctorById(long id);
}
