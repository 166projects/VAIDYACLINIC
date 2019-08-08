package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.PatientDao;
import com.mphasis.training.entities.Patient;

@Service

public class PatientBoImpl implements PatientBo {

	@Autowired
	PatientDao patientDao;

	public void insertPatient(Patient patient) {
		patientDao.insertPatient(patient);
	}

	public List<Patient> getPatientsByName(String firstname) {
		return patientDao.getPatientsByName(firstname);
	}

	public Patient getPatientById(int pid) {
		return patientDao.getPatientById(pid);
	}

	public void updatePatient(Patient patient) {
		 patientDao.updatePatient(patient);
			
	}

}
