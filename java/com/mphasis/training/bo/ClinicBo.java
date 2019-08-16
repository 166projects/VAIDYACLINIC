package com.mphasis.training.bo;

import java.util.List;

import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Location;

public interface ClinicBo {

	public void insertClinic(Clinic clinic);
	public void updateClinic(Clinic clinic);
	public void deleteClinic(int cid);
	public List<Clinic> getClinics();
	public Clinic getClinicsByClinicName(Clinic clinic);
	public List<Clinic> getClinicByLocation(String location_name);
}


