package com.mphasis.training.bo;

import java.time.LocalDate;
import java.util.List;

import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Doctor;

public interface AppointmentBo {

	public void insertAppointment(Appointment appointment);
	public void updateAppointment(Appointment appointment);
	public List<Appointment> getAppointments();
	public void deleteAppointment(String aId);
	public List<Appointment> getAppointmentByDoctorAndDate(String dId,String date);
	public void approveAppointment(Appointment appointment);

}
