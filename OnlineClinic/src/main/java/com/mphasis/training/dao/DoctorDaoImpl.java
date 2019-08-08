package com.mphasis.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.training.dao.DoctorDao;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		session.save(doctor);
		session.close();

	}

	public void updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDoctor(int did) {
		// TODO Auto-generated method stub
		
	}

	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Doctor> getDoctorByClinic(Clinic clinic) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
