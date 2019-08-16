package com.mphasis.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertRole(Role role) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(role);
		tr.commit();

	}

	public List<Role> getRoles() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<Role> roles = session.createCriteria(Role.class).list();
		tr.commit();
		return roles;

	}

}
