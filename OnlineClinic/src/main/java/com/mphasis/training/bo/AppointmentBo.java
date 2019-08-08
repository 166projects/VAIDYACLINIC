package com.mphasis.training.bo;

import java.util.List;

import com.mphasis.training.entities.Appointment;

public interface AppointmentBo {

	public void insertAppointment(Appointment appointment);
	public void updateAppointment(Appointment appointment);
	public List<Appointment> getAppointments();
	public void deleteAppointment(int aid); 
}
