package com.mphasis.training.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Member;

@Repository
public class LoginImpl implements LoginDao {
	  @Autowired
	  SessionFactory sessionFactory;

	public Member LoginImpl(String email, String password) {

System.out.println(email);
		
	       Member member=null;
	    try {   Session session = sessionFactory.openSession();		
           TypedQuery query= session.createQuery("from Member where "
                                           + "email=:email and password=:password");

           
           query.setParameter("email", email);
           query.setParameter("password", password);
           member=(Member) query.getSingleResult();
}
	    catch (NoResultException e) {
			// TODO: handle exception
		}
           return member;

	}
 }

	      
               

