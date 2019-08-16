package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Patient;

public interface PatientDao {
	public void insertPatient(Patient patient);
	public void updatePatient(Patient patient);
	public List<Patient> getPatientsByName(String firstname);
	public Patient getPatientById(String pid);
	public String getPatientByMemberId(String mId);
	
}
