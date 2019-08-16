package com.mphasis.training.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.AppointmentDao;
import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Doctor;
@Service
public final class AppointmentBoImpl implements AppointmentBo {
@Autowired
AppointmentDao appointmentDao;
	public void insertAppointment(Appointment appointment) {
		 appointmentDao.insertAppointment(appointment);
	}
	public void updateAppointment(Appointment appointment) {
		appointmentDao.updateAppointment(appointment);
	}
	public List<Appointment> getAppointments() {
		return appointmentDao.getAppointments();
		
	}
	public void deleteAppointment(String aid) {
		
		appointmentDao.deleteAppointment(aid);
	}
	public List<Appointment> getAppointmentByDoctorAndDate(String dId,String date)
 {
		return appointmentDao.getAppointmentByDoctorandDate(dId,date);
	}
	public void approveAppointment(Appointment appointment)
	{
		appointmentDao.approveAppointment(appointment);
	}

}
