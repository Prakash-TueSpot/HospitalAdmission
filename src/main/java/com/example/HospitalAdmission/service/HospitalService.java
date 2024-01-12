package com.example.HospitalAdmission.service;

import java.util.List;

import com.example.HospitalAdmission.model.HospitalModel;

public interface HospitalService {
	public String Hospitaldetails(HospitalModel hosp);
	public String updatehospitaldetails(HospitalModel updhosp);
	List<HospitalModel> gethosp();
	public  String deleteuser(Integer Id);
	
}
