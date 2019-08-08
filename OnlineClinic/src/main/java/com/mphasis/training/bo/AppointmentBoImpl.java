package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.AppointmentDao;
import com.mphasis.training.entities.Appointment;
@Service
public final class AppointmentBoImpl implements AppointmentBo {
@Autowired
AppointmentDao appointmentDao;
	public void insertAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		 appointmentDao.insertAppointment(appointment);
	}
	public void updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		appointmentDao.updateAppointment(appointment);
	}
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return appointmentDao.getAppointments();
		
	}
	public void deleteAppointment(int aid) {
		// TODO Auto-generated method stub
		appointmentDao.deleteAppointment(aid);
	}

}
