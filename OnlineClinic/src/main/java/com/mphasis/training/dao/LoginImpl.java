package com.mphasis.training.dao;

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
	       Member member=null;
	       Session session = sessionFactory.openSession();		
           TypedQuery query= session.createQuery("from Member where "
                                           + "email=:email and password=:password");

           query.setParameter(1, email);
           query.setParameter(2, password);
           member=(Member) query.getSingleResult();
           System.out.println(member.getEmail());  
           return member;

	}

	                 }

	      
               

