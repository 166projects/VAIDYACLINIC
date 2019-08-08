package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Appointment;

public interface AppointmentDao {


	public void insertAppointment(Appointment appointment);
	public void updateAppointment(Appointment appointment);
	public List<Appointment> getAppointments();
	public void deleteAppointment(String aid); 
}


