package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;

public interface DoctorDao {
	public void insertDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public void deleteDoctor(String did) ;
	public List<Doctor> getDoctors();
	public List<Doctor> getDoctorByClinic(String clinic_name);
	public void updateDoctorOnDeny(Doctor doctor) ;
	public void updateDoctorOnApprove(Doctor doctor) ;

}
