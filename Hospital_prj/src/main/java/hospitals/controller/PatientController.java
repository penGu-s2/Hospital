package hospitals.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;

import exception.ResourceNotFoundException;
import hospitals.model.Patient;
import hospitals.repository.PatientRepository;

@RestController
@RequestMapping(value = "/api/patients")
public class PatientController {
	
	private PatientRepository patientRepo;
	@Autowired
	
	
	//private NurseService nurseService;
	
	public PatientController(@RequestBody PatientRepository patientRepo) {
		this.patientRepo=patientRepo;
	}
	
	@GetMapping(value = "/getAll")
	public List<Patient> getAllPatients(){
		return patientRepo.findAll();
	}
	
	@RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
	public List<Patient> updatePatient(@ApiPathParam(name="id" )@PathVariable(value = "id") long id, 
			@RequestBody Patient patient) throws ResourceNotFoundException{
		 Patient _patient =patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :"+id));
		 //_patient.setId(patient.getId());
		 _patient.setName(patient.getName());
		 _patient.setBirthday(patient.getBirthday());
		 _patient.setIdcard(patient.getIdcard());
		 _patient.setAddress(patient.getAddress());
		 _patient.setPhone(patient.getPhone());
		 
		 patientRepo.save(_patient);
		 return patientRepo.findAll();
		 
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public List<Patient> create(@RequestBody Patient patient){
		patientRepo.save(patient);

        return patientRepo.findAll();
    }
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiMethod(description = "Remove the patient with the provided ID from the database")
    public List<Patient> removePatient(@ApiPathParam(name = "id") @PathVariable long id){
        patientRepo.deleteById(id);

        return patientRepo.findAll();
    }

}
