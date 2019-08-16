package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.training.dao.ClinicDao;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Location;
@Service
public class ClinicBoImpl implements ClinicBo {
@Autowired
ClinicDao clinicDao;
	public void insertClinic(Clinic clinic) {

		System.out.println("inside ClinicDao");
		clinicDao.insertClinic(clinic);
	}

	public void updateClinic(Clinic clinic) {
		clinicDao.updateClinic(clinic);
	}

	public void deleteClinic(int cid) {
	clinicDao.deleteClinic(cid);	
	}


	public List<Clinic> getClinics(){
		return clinicDao.getClinics();
	}

	public Clinic getClinicsByClinicName(Clinic clinic) {
		return clinicDao.getClinicsByClinicName(clinic);
	}

	public List<Clinic> getClinicByLocation(String location_name) {
		return clinicDao.getClinicByLocation(location_name);
	}

}
