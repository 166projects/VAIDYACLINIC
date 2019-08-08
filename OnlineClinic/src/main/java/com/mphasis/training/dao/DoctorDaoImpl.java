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

	public void insertDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		//Transaction tr = session.beginTransaction();
		session.save(doctor);
		//tr.commit();

	}
		
	
	public void deleteDoctor(int did) {
		Session session = sessionFactory.openSession();
		//Transaction tr = session.beginTransaction();
		Doctor doctor = (Doctor) session.get(Doctor.class, did);
		session.delete(doctor);
	//	tr.commit();
	}
	
	public List<Doctor> getDoctors()
	{
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		List<Doctor> doctors = session.createCriteria(Doctor.class).list();
		return doctors;

	}
	public List<Doctor> getDoctorByClinic(Clinic clinic)
	{
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		List<Doctor> doctors = (List<Doctor>) session.get(Doctor.class,clinic.getClinic_name());
		return doctors;

	}
		
}
