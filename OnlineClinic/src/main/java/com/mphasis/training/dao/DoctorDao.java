package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;

public interface DoctorDao {
	public void insertDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public void deleteDoctor(int did) ;
	public List<Doctor> getDoctors();
	public List<Doctor> getDoctorByClinic(Clinic clinic);

}
