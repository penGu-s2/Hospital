package hospitals.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import hospitals.model.Doctor;
import hospitals.repository.DoctorRepository;
import hospitals.service.DoctorService;

@RestController
@RequestMapping(value = "/api/doctors")

public class DoctorController {
	
	private DoctorRepository doctorRepo;
	@Autowired
	
	
	//private DoctorService doctorService;
	
	public DoctorController(@RequestBody DoctorRepository doctorRepo) {
		this.doctorRepo=doctorRepo;
	}
	
	@GetMapping(value = "/getAll")
	public List<Doctor> getAllDoctors(){
		return doctorRepo.findAll();
	}
	
	@RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
	public List<Doctor> updateDoctor(@ApiPathParam(name="id" )@PathVariable(value = "id") long id, 
			@RequestBody Doctor doctor) throws ResourceNotFoundException{
		 Doctor _doctor =doctorRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :"+id));
		 //_doctor.setId(doctor.getId());
		 _doctor.setName(doctor.getName());
		 _doctor.setBirthday(doctor.getBirthday());
		 _doctor.setIdcard(doctor.getIdcard());
		 _doctor.setAddress(doctor.getAddress());
		 _doctor.setJoblv(doctor.getJoblv());
		 _doctor.setLiteracy(doctor.getLiteracy());
		 _doctor.setSeniority(doctor.getSeniority());
		 _doctor.setExpertise(doctor.getExpertise());
		 doctorRepo.save(_doctor);
		 return doctorRepo.findAll();
		 
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public List<Doctor> create(@RequestBody Doctor doctor){
		doctorRepo.save(doctor);

        return doctorRepo.findAll();
    }
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiMethod(description = "Remove the doctor with the provided ID from the database")
    public List<Doctor> removeDoctor(@ApiPathParam(name = "id") @PathVariable long id){
        doctorRepo.deleteById(id);

        return doctorRepo.findAll();
    }

}
