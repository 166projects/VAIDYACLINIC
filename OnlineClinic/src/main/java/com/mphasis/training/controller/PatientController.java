
package com.mphasis.training.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.Exception.BusinessException;
import com.mphasis.training.bo.PatientBo;
import com.mphasis.training.entities.Patient;
@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientBo patientBo;



	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addPatient(@RequestBody Patient patient) {
		patientBo.insertPatient(patient);
	}


@RequestMapping(value="/add",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
public void updatePatient(@RequestBody Patient patient)
{
  Patient patient1=patientBo.getPatientById(patient.getpId());
	if(patient1!=null)
 patientBo.updatePatient(patient1);
	else
	throw new BusinessException("no patient found");
}



	@RequestMapping(value = "/patients/{pId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient getpatientsById(@PathVariable("pId") String pId) {

		return patientBo.getPatientById(pId);

	}

	@RequestMapping(value = "/patients/{firstname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Patient getPatientByName(@PathVariable("firstname") String firstname) {

		return (Patient) patientBo.getPatientsByName(firstname);

	}

}
