package com.mphasis.training.dao;

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

import com.mphasis.training.bo.SpecializationBo;
import com.mphasis.training.dao.DoctorDao;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;
import com.mphasis.training.entities.Location;
import com.mphasis.training.entities.Member;

@Repository
public class DoctorDaoImpl implements DoctorDao {
	@Autowired
	SessionFactory sessionFactory;

	
	public void insertDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(doctor);
		tr.commit();

	}	
	public void deleteDoctor(String did) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Doctor doctor = (Doctor) session.get(Doctor.class, did);
		session.delete(doctor);
		tr.commit();
	}
	
	public List<Doctor> getDoctors()
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		List<Doctor> doctors = session.createCriteria(Doctor.class).list();
		tr.commit();
		return doctors;

	}
	public List<Doctor> getDoctorByClinic(String clinic_name)
	{
		List<Doctor> doctors =null;

		try{Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		//session.get(Location.class, location_name);
		TypedQuery query=session.createQuery("from Clinic where clinic_name=:clinic_name");
		query.setParameter("clinic_name", clinic_name);
		Clinic clinic= (Clinic) query.getSingleResult();
		System.out.println("dao called"+clinic);
		NativeQuery query1=session.createSQLQuery("select * from doctor where clinic_cid=:cId");
		query1.setParameter("cId", clinic.getcId());
		
		doctors =query1.list();
		//List<Clinic> clinics = session.createQuery(Clinic.class,location.getLocId()).list();

		tr.commit();
		}catch (NoResultException e) {
			// TODO: handle exception
		}
		return doctors;

		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void updateDoctorOnApprove(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Doctor doctor1 = (Doctor) session.get(Doctor.class, doctor.getdId());
		doctor1.setDoctor_status(0);
		session.update(doctor1);
		tr.commit();		
	}
	public void updateDoctorOnDeny(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Doctor doctor1 = (Doctor) session.get(Doctor.class, doctor.getdId());
		doctor1.setDoctor_status(1);
		session.update(doctor1);
		tr.commit();		
	}
	
	public void updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}
}
