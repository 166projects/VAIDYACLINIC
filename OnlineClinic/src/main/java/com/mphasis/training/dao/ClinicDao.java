package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Clinic;

public interface ClinicDao {

	public void insertClinic(Clinic clinic);

	public void updateClinic(Clinic clinic);

	public void deleteClinic(int cid);

	public List<Clinic> getClinics();

	public Clinic getClinicsByClinicName(Clinic clinic);
}
