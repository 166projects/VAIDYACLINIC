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
@Transactional
public class PatientDaoImpl implements PatientDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertPatient(Patient patient) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(patient);
		session.close();
	}

	public void updatePatient(int pid) {
		Session session = sessionFactory.openSession();
		session.update(pid);
		session.close();
	}

	public List<Patient> getPatientsByName(String firstname) {
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		List<Patient> patients = session.createCriteria(Member.class,firstname).list();
		session.close();
		return patients;

	}

	public Patient getPatientById(int pid) {
		Session session = sessionFactory.openSession();
		System.out.println("Inside Dao");
		Patient patients = (Patient) session.get(Patient.class, pid);
		session.close();
		return patients;

	}
}
