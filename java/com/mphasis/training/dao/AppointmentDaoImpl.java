package com.mphasis.training.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Doctor;
import com.mphasis.training.entities.Leave;
import com.mphasis.training.entities.Location;
import com.mphasis.training.entities.Patient;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	@Autowired
	SessionFactory sessionFactory;

	public void insertAppointment(Appointment appointment) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(appointment);
		tr.commit();

	}

	public List<Appointment> getAppointmentByDoctorandDate(String dId, String date) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();

//		DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
//		String formattedDate = appointment_date.format(format);
//		System.out.println("Inside Appointment Dao");

		NativeQuery query1 = session.createSQLQuery(
				"select * from appointment a join doctor d on a.doctor_dId = d.dId where a.doctor_dId=:dId and a.appointment_date=:date");
		query1.setParameter("dId", dId);
		query1.setParameter("date", date);

		List<Appointment> appointments = query1.list();

		tr.commit();
		return appointments;

	}

	public void updateAppointment(Appointment appointment) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(appointment);
		tr.commit();

	}

	public List<Appointment> getAppointments() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		List<Appointment> appointments = session.createCriteria(Appointment.class).list();
		return appointments;

	}/*
		 * public List<Appointment> getAppointmentByDate(LocalDateTime appointment_time)
		 * {
		 * 
		 * Session session = sessionFactory.openSession();
		 * System.out.println("Inside Dao"); List<Appointment> appointments =
		 * session.createCriteria(Appointment.class,appointment_time).list(); return
		 * appointments; }
		 */

	public void deleteAppointment(String aid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(aid);
		tr.commit();
	}
	public void approveAppointment(Appointment appointment) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		if(appointment.getDoctor().getDoctor_status()==1)
		{
		Appointment appointment1= (Appointment) session.get(Appointment.class, appointment.getaId());
		System.out.println(appointment1.getAppointment_status());
		appointment1.setAppointment_status("approved");
		session.update(appointment1);
		tr.commit();
		}
		else {
			Appointment appointment1= (Appointment) session.get(Appointment.class, appointment.getaId());
			System.out.println(appointment1.getAppointment_status());
			appointment1.setAppointment_status("denied");
			session.update(appointment1);
			tr.commit();
				
		}
		
	}

	
	
}
