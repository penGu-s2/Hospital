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
import hospitals.model.Nurse;
import hospitals.repository.NurseRepository;
import hospitals.service.NurseService;

@RestController
@RequestMapping(value = "/api/nurses")

public class NurseController {
	
	private NurseRepository nurseRepo;
	@Autowired
	
	
	//private NurseService nurseService;
	
	public NurseController(@RequestBody NurseRepository nurseRepo) {
		this.nurseRepo=nurseRepo;
	}
	
	@GetMapping(value = "/getAll")
	public List<Nurse> getAllNurses(){
		return nurseRepo.findAll();
	}
	
	@RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
	public List<Nurse> updateNurse(@ApiPathParam(name="id" )@PathVariable(value = "id") long id, 
			@RequestBody Nurse nurse) throws ResourceNotFoundException{
		 Nurse _nurse =nurseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nurse not found for this id :"+id));
		 //_nurse.setId(nurse.getId());
		 _nurse.setName(nurse.getName());
		 _nurse.setBirthday(nurse.getBirthday());
		 _nurse.setIdcard(nurse.getIdcard());
		 _nurse.setAddress(nurse.getAddress());
		 _nurse.setPhone(nurse.getPhone());
		 _nurse.setLiteracy(nurse.getLiteracy());
		 _nurse.setSeniority(nurse.getSeniority());
		 nurseRepo.save(_nurse);
		 return nurseRepo.findAll();
		 
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public List<Nurse> create(@RequestBody Nurse nurse){
		nurseRepo.save(nurse);

        return nurseRepo.findAll();
    }
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiMethod(description = "Remove the nurse with the provided ID from the database")
    public List<Nurse> removeNurse(@ApiPathParam(name = "id") @PathVariable long id){
        nurseRepo.deleteById(id);

        return nurseRepo.findAll();
    }

}
