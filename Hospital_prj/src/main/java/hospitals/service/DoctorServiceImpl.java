package hospitals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hospitals.model.Doctor;
import hospitals.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	@Override
	public void saveDoctor(Doctor doctor) {
		this.doctorRepository.save(doctor);
	}
	
	@Override
	public Doctor getDoctorById(long id) {
		Optional<Doctor> optional = doctorRepository.findById(id);
		Doctor doctor = null;
		if (optional.isPresent()) {
			doctor = optional.get();
		}
		else {
			throw new RuntimeException("Doctor not found for id :: " + id);
		}
		return doctor;
	}
	
	@Override
	public void deleteDoctorById(long id) {
		this.doctorRepository.deleteById(id);
	}
}
