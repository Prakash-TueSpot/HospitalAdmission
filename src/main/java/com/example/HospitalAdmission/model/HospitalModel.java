package com.example.HospitalAdmission.model;

public class HospitalModel {
	private int hospadmissionid;
	private String patientname;
	private String typeofdisease;
	private String typeofroom;
	private String feesdetails;
	public int getHospadmissionid() {
		return hospadmissionid;
	}
	public void setHospadmissionid(int hospadmissionid) {
		this.hospadmissionid = hospadmissionid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getTypeofdisease() {
		return typeofdisease;
	}
	public void setTypeofdisease(String typeofdisease) {
		this.typeofdisease = typeofdisease;
	}
	public String getTypeofroom() {
		return typeofroom;
	}
	public void setTypeofroom(String typeofroom) {
		this.typeofroom = typeofroom;
	}
	public String getFeesdetails() {
		return feesdetails;
	}
	public void setFeesdetails(String feesdetails) {
		this.feesdetails = feesdetails;
	}
	public HospitalModel(int hospadmissionid, String patientname, String typeofdisease, String typeofroom,
			String feesdetails) {
		super();
		this.hospadmissionid = hospadmissionid;
		this.patientname = patientname;
		this.typeofdisease = typeofdisease;
		this.typeofroom = typeofroom;
		this.feesdetails = feesdetails;
	}
	public HospitalModel() {
		super();
	}
	@Override
	public String toString() {
		return "HospitalModel [hospadmissionid=" + hospadmissionid + ", patientname=" + patientname + ", typeofdisease="
				+ typeofdisease + ", typeofroom=" + typeofroom + ", feesdetails=" + feesdetails + "]";
	}
	
	

}
