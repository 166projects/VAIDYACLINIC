package com.mphasis.training.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_seq")
	@GenericGenerator(
			name = "leave_seq",
			strategy = "com.mphasis.training.entities.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "LV"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
		private String lId;
	
	@Column(nullable=true)
	private String todate;
	@Column(nullable=true)
	private String fromdate;
	
	private int leave_status;
	

	private String reason;

	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	public String getlId() {
		return lId;
	}

	public void setlId(String lId) {
		this.lId = lId;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public int getLeave_status() {
		return leave_status;
	}

	public void setLeave_status(int leave_status) {
		this.leave_status = leave_status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
