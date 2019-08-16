package com.mphasis.training.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.training.bo.DoctorBo;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;
import com.mphasis.training.entities.Leave;
import com.mphasis.training.webrequestview.LeaveView;

@Repository
public class LeaveDaoImpl implements LeaveDao {
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DoctorBo doctorBo;

	public void insertLeave(Leave leave) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		leave.setLeave_status(2);
		session.save(leave);
		tr.commit();
	}

	public void approveLeave(Leave leave) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Leave leave1 = (Leave) session.get(Leave.class, leave.getlId());
		System.out.println(leave1.getLeave_status());
		leave1.setLeave_status(1);
		session.update(leave1);
		tr.commit();
		
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String strDate = dateFormat.format(date); 
		
		Session session1 = sessionFactory.openSession();
		Transaction tr1 = session1.beginTransaction();
		if(strDate.matches(leave.getFromdate())) {
		Doctor doctor = session1.get(Doctor.class, leave1.getDoctor().getdId());
		doctor.setDoctor_status(0);
		doctorBo.updateDoctor(doctor);
		tr1.commit();
		}
		else
		{
			Doctor doctor = session1.get(Doctor.class, leave1.getDoctor().getdId());
			doctor.setDoctor_status(1);
			doctorBo.updateDoctor(doctor);
			tr1.commit();
		
			
		}
	}

	public void denyLeave(Leave leave) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Leave leave1 = (Leave) session.get(Leave.class, leave.getlId());
		leave1.setLeave_status(0);
		session.update(leave1);
		tr.commit();

//		Date date = Calendar.getInstance().getTime();  
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//		String strDate = dateFormat.format(date); 
	
		
		Session session1 = sessionFactory.openSession();
		Transaction tr1 = session1.beginTransaction();
		Doctor doctor = session1.get(Doctor.class, leave1.getDoctor().getdId());
		doctor.setDoctor_status(1);
		doctorBo.updateDoctor(doctor);
		tr1.commit();
	}

	public void deleteLeave(String lid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Leave leave = (Leave) session.get(Leave.class, lid);
		session.delete(leave);
		tr.commit();

	}

	public void updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Leave leave1 = (Leave) session.get(Leave.class, leave.getlId());
		leave1.setReason(leave.getReason());
		leave1.setTodate(leave.getTodate());
		leave1.setFromdate(leave.getFromdate());
		session.update(leave1);
		tr.commit();

	}
	public List<Leave> getLeaves() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<Leave> leaves = session.createCriteria(Leave.class).list();
		tr.commit();
		return leaves;
	}


}
