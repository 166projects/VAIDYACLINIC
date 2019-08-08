package com.mphasis.training.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Doctor;
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
		public List<Appointment> getAppointmentByDate(LocalDateTime appointment_time)
		{
			
			Session session = sessionFactory.openSession();
			System.out.println("Inside Dao");
			DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
			String formattedDateTime = appointment_time.format(format);
			List<Appointment> appointments = session.createCriteria(Appointment.class,formattedDateTime).list();
			session.close();
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

	public void deleteAppointment(int aid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(aid);
		tr.commit();
	}

}
