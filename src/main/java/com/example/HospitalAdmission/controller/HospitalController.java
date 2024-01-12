package com.example.HospitalAdmission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalAdmission.model.HospitalModel;
import com.example.HospitalAdmission.service.HospitalService;

@RestController
@RequestMapping("/api/h10/hospital")
public class HospitalController {
	@Autowired
	private HospitalService hosp;
	
//Post Method
	@PostMapping("/")
	public String Hospitaldetails(@RequestBody HospitalModel hospit)
	{
		System.out.println(hosp.toString());
		return hosp.Hospitaldetails(hospit) ;
	}
//Put Method
	@PutMapping("/")
	public String updatehospitaldetails(@RequestBody HospitalModel updhosp)
	{
	System.out.println(updhosp.toString());
	return hosp.updatehospitaldetails(updhosp);
	}
//Get Method
	@GetMapping("/")
	public List<HospitalModel> getHospitalModel(){
		List<HospitalModel> gethosp=hosp.gethosp();
		return gethosp ;
	}

@GetMapping("/{id}")
public void getuser(@PathVariable("id") Integer Id) {
	System.out.println("get By id" + Id);
}

@DeleteMapping("/{id}")
public String deleteuser(@PathVariable("id") Integer Id) {
	System.out.println("delete By id" + Id);
	return hosp.deleteuser(Id);
}
}
