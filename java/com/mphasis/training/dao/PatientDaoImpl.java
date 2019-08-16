package com.mphasis.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Location;
import com.mphasis.training.entities.Member;
import com.mphasis.training.entities.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {
	@Autowired
	SessionFactory sessionFactory;
	Transaction tr;

	public void insertPatient(Patient patient) {

		Session session = sessionFactory.openSession();
		tr = session.beginTransaction();
		session.save(patient);
		tr.commit();
		session.close();
	}

	public void updatePatient(Patient patient) {
		Session session = sessionFactory.openSession();
		tr = session.beginTransaction();
		session.update(patient);
		tr.commit();
		session.close();
	}

	public List<Patient> getPatientsByName(String firstname) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

		TypedQuery query = session.createQuery("from Member where firstName=:firstname");
		query.setParameter("firstname", firstname);
		Member member = (Member) query.getSingleResult();
		System.out.println("dao called" + member);

		NativeQuery query1 = session.createSQLQuery("select * from patient where member_id=:mId");
		query1.setParameter("mId", member.getmId());

		List<Patient> patients = query1.list();

		tr.commit();
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

	public void updatePatient(int pid) {
		// TODO Auto-generated method stub

	}

	public String getPatientByMemberId(String mId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Inside Dao");
		NativeQuery query = session
				.createSQLQuery("select pId from patient p join member m on p.member_id = m.mId where m.mId=:mId");
		query.setParameter("mId", mId);
		String patient =  (String) query.getSingleResult();
		System.out.println(patient);
		return patient;
	}
}
