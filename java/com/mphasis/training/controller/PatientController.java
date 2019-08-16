
package com.mphasis.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.Exception.BusinessException;
import com.mphasis.training.bo.AppointmentBo;
import com.mphasis.training.bo.ClinicBo;
import com.mphasis.training.bo.DoctorBo;
import com.mphasis.training.bo.LocationBo;
import com.mphasis.training.bo.PatientBo;
import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;
import com.mphasis.training.entities.Location;
import com.mphasis.training.entities.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientBo patientBo;

	@Autowired
	AppointmentBo appointmentBo;
	
	@Autowired
	LocationBo locationBo;
	
	@Autowired
	ClinicBo clinicBo;
	
	@Autowired
	DoctorBo doctorBo;
	

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addPatient(@RequestBody Patient patient) {
		patientBo.insertPatient(patient);
	}
//
//	@RequestMapping(value = "/add", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void updatePatient(@RequestBody Patient patient) {
//		Patient patient1 = patientBo.getPatientById(patient.getpId());
//		if (patient1 != null)
//			patientBo.updatePatient(patient1);
//		else
//			throw new BusinessException("no patient found");
//	}

//	@RequestMapping(value = "/patients/{pId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Patient getpatientsById(@PathVariable("pId") String pId) {
//
//		return patientBo.getPatientById(pId);
//
//	}
//
//	@RequestMapping(value = "/patients/{firstname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Patient getPatientByName(@PathVariable("firstname") String firstname) {
//
//		return (Patient) patientBo.getPatientsByName(firstname);
//
//	}

	@RequestMapping(value = "/addAppointment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertAppointment(@RequestBody Appointment appointment) {
		appointmentBo.insertAppointment(appointment);
	}

	@RequestMapping(value = "/appointment/{aId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAppointment(@PathVariable("aId") String aId) {
		appointmentBo.deleteAppointment(aId);
	}

	@RequestMapping(value = "/appointment", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateAppointment(@RequestBody Appointment appointment) {
		appointmentBo.updateAppointment(appointment);
	}
	
	@RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getAllLocation() {
		return locationBo.getLocation();
	}
	@RequestMapping(value = "/clinics/{location_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Clinic> getClinicByLocation(@PathVariable String location_name) {
		return clinicBo.getClinicByLocation(location_name);
	}
	
	@RequestMapping(value = "/doctors/{clinic_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Doctor> getDoctorbyClinic(@RequestBody String clinic_name) {
		return doctorBo.getDoctorByClinic(clinic_name);
	}
	@RequestMapping(value = "/patients/{mId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPatientByMemberId(@PathVariable String mId) {
		return patientBo.getPatientByMemberId(mId);
	}
	

}
