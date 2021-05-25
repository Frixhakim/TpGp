 package com.todo.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.entities.Patient;
import com.todo.repositories.PatientRepository;

@Controller
public class PatientController {
	@Autowired
private PatientRepository patientrepository;
	@GetMapping(path = "/")
	public String index() {
		return "index";
	}
	@GetMapping(path = "/patients")
	public String list(Model model ,@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="4")int size,
			@RequestParam(name="key",defaultValue="")String k){
		Page<Patient> Pagepatients=patientrepository.findByNomContains(k,PageRequest.of(page, size));
		//send data to view
	model.addAttribute("patients",Pagepatients.getContent());	
	model.addAttribute("pages", new int[Pagepatients.getTotalPages()]);
	model.addAttribute("currentpage",page);
	model.addAttribute("size",size);
	model.addAttribute("key",k);
	 return "patient";
	}
	
	//delete by id
	@GetMapping(path = "/deletePatient")
	public String delete(Long id,String key,int page,int size) {
		patientrepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&key"+key;
	}
	//add
	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patient",new Patient());
		model.addAttribute("mode","new");
		return "formPatient";
	}
	// save
	@PostMapping(path = "/savePatient")
	public String savePatient(Patient patient,Model model) {
		patientrepository.save(patient);
		model.addAttribute("patient", patient);
		return "confirmation";
		
	}
	// edit
	@GetMapping(path = "/editPatient")
	public String editPatient(Model model,Long id) {
		Patient p=patientrepository.findById(id).get();
		model.addAttribute("patient",p);
		model.addAttribute("mode","edit");
		return "formPatient";
	}
}
