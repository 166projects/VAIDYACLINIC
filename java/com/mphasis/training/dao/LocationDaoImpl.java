package com.mphasis.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.training.entities.Location;

@Repository
public class LocationDaoImpl implements LocationDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertLocation(Location location) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(location);
		tr.commit();
	}

	public void updateLocation(Location location) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Location location1 = (Location) session.get(Location.class, location.getLocId());
		location1.setLocation_name(location.getLocation_name());
		session.update(location1);
		tr.commit();

	}

	public void deleteLocation(int lid) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Location location = (Location) session.get(Location.class, lid);
		session.delete(location);
		tr.commit();
		

	}

	public List<Location> getLocation() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		List<Location> locations = session.createCriteria(Location.class).list();
		tr.commit();
		return locations;

	}

}