package com.mphasis.training.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.entities.Leave;

@Repository
public class LeaveDaoImpl implements LeaveDao {
	@Autowired
	SessionFactory sessionFactory;
	public void insertLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	public void approveLeave(Leave leave) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Leave leave1= (Leave) session.get(Leave.class, leave.getlId());
		leave1.setLeave_status(1);
		session.update(leave);
	}

	public void denyLeave(Leave leave) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Leave leave1= (Leave) session.get(Leave.class, leave.getlId());
		leave1.setLeave_status(0);
		session.update(leave);
		session.close();
	}
	public void deleteLeave(int liv) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		//Transaction tr = session.beginTransaction();
		Leave leave = (Leave) session.get(Leave.class, liv);
		session.delete(leave);
		
	}

	public void updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		//Transaction tr = session.beginTransaction();
		Leave leave1 = (Leave) session.get(Leave.class, leave.getlId());
		leave.setLeave_status(leave.getLeave_status());
		session.update(leave1);
		
	}


}
