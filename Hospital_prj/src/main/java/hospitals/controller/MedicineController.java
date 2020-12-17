package hospitals.controller;

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
import hospitals.model.Medicine;
import hospitals.repository.MedicineRepository;

@RestController
@RequestMapping(value = "/api/medicines")
public class MedicineController {
	
	private MedicineRepository medicineRepo;
	@Autowired
	
	
	//private NurseService nurseService;
	
	public MedicineController(@RequestBody MedicineRepository medicineRepo) {
		this.medicineRepo=medicineRepo;
	}
	
	@GetMapping(value = "/getAll")
	public List<Medicine> getAllMedicines(){
		return medicineRepo.findAll();
	}
	
	@RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
	public List<Medicine> updateMedicine(@ApiPathParam(name="id" )@PathVariable(value = "id") long id, 
			@RequestBody Medicine medicine) throws ResourceNotFoundException{
		 Medicine _medicine =medicineRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Medicine not found for this id :"+id));
		 //_medicine.setId(medicine.getId());
		 _medicine.setName(medicine.getName());
		 _medicine.setPrice(medicine.getPrice());

		 medicineRepo.save(_medicine);
		 return medicineRepo.findAll();
		 
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public List<Medicine> create(@RequestBody Medicine medicine){
		medicineRepo.save(medicine);

        return medicineRepo.findAll();
    }
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiMethod(description = "Remove the medicine with the provided ID from the database")
    public List<Medicine> removeMedicine(@ApiPathParam(name = "id") @PathVariable long id){
        medicineRepo.deleteById(id);

        return medicineRepo.findAll();
    }

}
