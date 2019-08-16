package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.DoctorDao;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;
@Service
public class DoctorBoImpl implements DoctorBo {
@Autowired
DoctorDao doctorDao;
	public void insertDoctor(Doctor doctor) {
	doctorDao.insertDoctor(doctor);	
	}

	public void updateDoctor(Doctor doctor) {
		doctorDao.updateDoctor(doctor);
	}

	public void deleteDoctor(String did) {
	doctorDao.deleteDoctor(did);	
	}

	public List<Doctor> getDoctors() {
		return doctorDao.getDoctors();
	}

	public List<Doctor> getDoctorByClinic(String clinic_name) {
		return doctorDao.getDoctorByClinic(clinic_name);
	}

	public void updateDoctorOnDeny(Doctor doctor) {
		doctorDao.updateDoctorOnDeny(doctor);
	}

	public void updateDoctorOnApprove(Doctor doctor) {
	doctorDao.updateDoctorOnApprove(doctor);	
	}

}
