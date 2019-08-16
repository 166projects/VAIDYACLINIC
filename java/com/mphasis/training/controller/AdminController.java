package com.mphasis.training.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.training.bo.AppointmentBo;
import com.mphasis.training.bo.ClinicBo;
import com.mphasis.training.bo.DoctorBo;
import com.mphasis.training.bo.LocationBo;
import com.mphasis.training.bo.MemberBo;
import com.mphasis.training.bo.PatientBo;
import com.mphasis.training.bo.RoleBo;
import com.mphasis.training.bo.SpecializationBo;
import com.mphasis.training.dao.LocationDao;
import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;
import com.mphasis.training.entities.Location;
import com.mphasis.training.entities.Member;
import com.mphasis.training.entities.Patient;
import com.mphasis.training.entities.Role;
import com.mphasis.training.entities.Specialization;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ClinicBo clinicBo;
	
	@Autowired
	LocationBo locationBo;
	
	@Autowired
	DoctorBo doctorBo;
	
	@Autowired
	SpecializationBo specializationBo;
	
	@Autowired
	MemberBo memberBo;

	@Autowired
	AppointmentBo appointmentBo;
	
	@Autowired
	PatientBo patientBo;
	
	@Autowired
	RoleBo roleBo;
	
	@RequestMapping(value = "/clinics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Clinic> getAll() {
		return clinicBo.getClinics();

	}
	@RequestMapping(value = "/clinics/{location_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Clinic> getClinicByLocation(@PathVariable(value ="location_name") String location_name) {
		System.out.println("location name is "+location_name);
		return clinicBo.getClinicByLocation(location_name);
	}
	

	@RequestMapping(value = "/addClinic", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addClinic(@RequestBody Clinic clinic) {

		clinicBo.insertClinic(clinic);
	}
	
	@RequestMapping(value = "/addRole", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addRole(@RequestBody Role role) {
		roleBo.insertRole(role);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Role> getAllRoles() {
		return roleBo.getRoles();
	}

	
	@RequestMapping(value = "/addLocation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addLocation(@RequestBody Location location) {

		locationBo.insertLocation(location);
	}

	@RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Location> getAllLocation() {
		return locationBo.getLocation();
	}

	@RequestMapping(value = "/doctors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Doctor> getAllDoctors() {
		return doctorBo.getDoctors();
	}

	@RequestMapping(value = "/doctors/{clinic_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Doctor> getDoctorbyClinic(@PathVariable("clinic_name") String clinic_name) {
		return doctorBo.getDoctorByClinic(clinic_name);
	}

	@RequestMapping(value = "/deleteDoctor/{dId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteDoctor(@PathVariable("dId") String dId) {
		doctorBo.deleteDoctor(dId);
	}

	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void insertDoctor(@RequestBody Doctor doctor) {
		doctorBo.insertDoctor(doctor);
	}

	@RequestMapping(value = "/addSpecialization", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addSpecialization(@RequestBody Specialization specialization) {
		specializationBo.insertSpecialization(specialization);
	}

	@RequestMapping(value = "/addMember", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Member insertMember(@RequestBody Member member) {
		return memberBo.insertMember(member);
	}

	@RequestMapping(value = "/deleteMember/{mId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteMember(@PathVariable("mId") String mId) {
		memberBo.deleteMember(mId);
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateMember(@RequestBody Member member) {
		memberBo.updateMember(member);
	}

	@RequestMapping(value = "/members", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Member> getAllMembers() {
		return memberBo.getMember();

	}
	@RequestMapping(value = "/patients/{firstname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getPatientByName(@PathVariable("firstname") String firstname) {
		return patientBo.getPatientsByName(firstname);
	}
	
	@RequestMapping(value = "/appointments/{dId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAppointmentByDoctorAndDate(@PathVariable("dId") String dId, @PathVariable("date") String date) {
		
		return appointmentBo.getAppointmentByDoctorAndDate(dId,date);
	}
	
	@RequestMapping(value = "/appointments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAllAppointments() {
		return appointmentBo.getAppointments();

	}
	@RequestMapping(value = "/approveAppointment", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void approveAppointment(@RequestBody Appointment appointment) {
		appointmentBo.approveAppointment(appointment);
	}




}
