package hospitals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewHome {
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String ViewHome(){
        return "HomePage";
    }
	@RequestMapping(value="/patient",method = RequestMethod.GET)
    public String viewPatient(){
        return "patient";
    }
	@RequestMapping(value="/nurse",method = RequestMethod.GET)
    public String viewNurse(){
        return "nurse";
    }
	@RequestMapping(value="/doctor",method = RequestMethod.GET)
    public String viewDoctor(){
        return "doctor";
    }
	@RequestMapping(value="/medicine",method = RequestMethod.GET)
    public String viewMedicine(){
        return "medicine";
    }
}
