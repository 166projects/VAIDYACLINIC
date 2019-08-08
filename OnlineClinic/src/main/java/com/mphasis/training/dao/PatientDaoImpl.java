package com.mphasis.training.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Member;
import com.mphasis.training.entities.Patient;
@Repository
public class PatientDaoImpl implements PatientDao {
	@Autowired
	SessionFactory sessionFactory;
	Transaction tr;
	public void insertPatient(Patient patient) {
		
		Session session = sessionFactory.openSession();
		tr=session.beginTransaction();
		session.save(patient);
		tr.commit();
		session.close();
	}

	public void updatePatient(Patient patient) {
		Session session = sessionFactory.openSession();
		tr=session.beginTransaction();
		session.update(patient);
		tr.commit();
		session.close();
	}

	public List<Patient> getPatientsByName(String firstname) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Inside Dao");
		List<Patient> patients = session.createCriteria(Member.class,firstname).list();
		session.close();
		return patients;

	}

	public Patient getPatientById(String pid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Inside Dao");
		Patient patients = (Patient) session.get(Patient.class, pid);
		session.close();
		return patients;

	}
}
