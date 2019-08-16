package com.mphasis.training.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "appointment_date", "appointment_time" }))
@Entity
public class Appointment {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appoint_seq")
	@GenericGenerator(name = "appoint_seq", strategy = "com.mphasis.training.entities.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AP"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })

	private String aId;

	private String disease;

	@Column(nullable = true)
	private String appointment_date;

	@Column(nullable = true)
	private String appointment_time;

	private String remark;

	private String appointment_status;

	@ManyToOne(fetch = FetchType.EAGER)
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.EAGER)
	private Patient patient;

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getAppointment_time() {
		return appointment_time;
	}

	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAppointment_status() {
		return appointment_status;
	}

	public void setAppointment_status(String appointment_status) {
		this.appointment_status = appointment_status;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
