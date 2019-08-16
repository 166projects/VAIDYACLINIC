package com.mphasis.training.dao;

import java.time.LocalDate;
import java.util.List;

import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Doctor;

public interface AppointmentDao {


	public void insertAppointment(Appointment appointment);
	public void updateAppointment(Appointment appointment);
	public List<Appointment> getAppointments();
	public void deleteAppointment(String aid); 
	public List<Appointment> getAppointmentByDoctorandDate(String dId,String date);
	public void approveAppointment(Appointment appointment);

}


