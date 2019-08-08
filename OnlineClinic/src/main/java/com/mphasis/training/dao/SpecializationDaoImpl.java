package com.mphasis.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.training.entities.Location;
import com.mphasis.training.entities.Specialization;
@Transactional
@Repository
public class SpecializationDaoImpl implements SpecializationDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertSpecialization(Specialization specialization) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(specialization);
		tr.commit();
	
	}

	public void updateSpecialization(Specialization specialization) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Specialization specialization1 = (Specialization) session.get(Specialization.class, specialization.getsId());
		specialization1.setSpecialization_name(specialization.getSpecialization_name());
		specialization1.setDoctors(specialization.getDoctor());
		session.update(specialization1);
		tr.commit();
		
	}

}
