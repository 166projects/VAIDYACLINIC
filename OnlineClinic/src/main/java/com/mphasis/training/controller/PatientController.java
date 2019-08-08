
package com.mphasis.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.bo.PatientBo;
import com.mphasis.training.entities.Patient;
@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientBo patientBo;

//	@RequestMapping(value = "/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<Patient> getAll() {
//	
//	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addPatient(@RequestBody Patient patient) {
		patientBo.insertPatient(patient);
	}

	@RequestMapping(value = "/add", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updatePatient(@RequestBody Patient patient) {
			patientBo.updatePatient(patient.getpId());
		
	
		
	}

//	@RequestMapping(value = "/add/{pId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void deletePatient(@PathVariable("pId") int pId) {
//
//		
//
//	}

	@RequestMapping(value = "/patient/{pId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient getpatientsById(@PathVariable("pId") int pId) {

		return patientBo.getPatientById(pId);

	}

	@RequestMapping(value = "/patient/{firstname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient getPatientByName(@PathVariable("firstname") String firstname) {

		return (Patient) patientBo.getPatientsByName(firstname);

	}

}
