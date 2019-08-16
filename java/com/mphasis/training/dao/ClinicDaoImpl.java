package com.mphasis.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;
import com.mphasis.training.entities.Location;

@Repository
public class ClinicDaoImpl implements ClinicDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertClinic(Clinic clinic) {

		System.out.println("inside DaoImpl");
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(clinic);
		tr.commit();
	}

	public void updateClinic(Clinic clinic) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Clinic clinic1 = (Clinic) session.get(Clinic.class, clinic.getcId());
		clinic1.setClinic_address(clinic.getClinic_address());
		clinic1.setLocation(clinic.getLocation());
		clinic1.setClinic_name(clinic.getClinic_name());
		List<Doctor> doctors = new ArrayList();

		clinic1.setDoctors(doctors);
		session.update(clinic1);
		tr.commit();
	}

	public void deleteClinic(int cid) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Clinic clinic = (Clinic) session.get(Clinic.class, cid);
		session.delete(clinic);
		tr.commit();

	}

	public List<Clinic> getClinics() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		List<Clinic> clinics = session.createCriteria(Clinic.class).list();
		tr.commit();
		return clinics;
	}

	public Clinic getClinicsByClinicName(Clinic clinic) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		Clinic clinic1 = (Clinic) session.get(Clinic.class, clinic.getClinic_name());

		tr.commit();
		return clinic1;
	}

	public List<Clinic> getClinicByLocation(String location_name) {
		List<Clinic> clinics=null;
		try{Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		//session.get(Location.class, location_name);
		TypedQuery query=session.createQuery("from Location where location_name=:location_name");
		query.setParameter("location_name", location_name);
		Location location= (Location) query.getSingleResult();
		System.out.println("dao called"+location);
		NativeQuery query1=session.createSQLQuery("select * from clinic where location_locId=:locId");
		query1.setParameter("locId", location.getLocId());
		
		clinics =query1.list();
		//List<Clinic> clinics = session.createQuery(Clinic.class,location.getLocId()).list();
		
		tr.commit();
		}catch (NoResultException e) {
			// TODO: handle exception
		}
		return clinics;

	}
}
