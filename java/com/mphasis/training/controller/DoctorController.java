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
import com.mphasis.training.bo.LeaveBo;
import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Leave;
import com.mphasis.training.entities.Member;
import com.mphasis.training.webrequestview.LeaveView;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	LeaveBo leaveBo;

	@Autowired
	AppointmentBo appointmentBo;

	@RequestMapping(value = "/addLeave", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addLeave(@RequestBody Leave leave) {
		leaveBo.insertLeave(leave);
	}
	
	@RequestMapping(value = "/addLeave", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateLeave(@RequestBody Leave leave) {
		leaveBo.updateLeave(leave);
	}
	@RequestMapping(value = "/deleteLeave/{lId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteLeave(@PathVariable("lId") String lId) {
		leaveBo.deleteLeave(lId);
	}
	
	@RequestMapping(value = "/appointments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAppointments() {
		return appointmentBo.getAppointments();
	}
	
	@RequestMapping(value = "/appointments/{dId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Appointment> getAppointmentByDoctorAndDate(@PathVariable("dId") String dId, @PathVariable("date") String date) {
		
		return appointmentBo.getAppointmentByDoctorAndDate(dId,date);
	}
	

}
