package com.mphasis.training.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
public class Specialization implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable=true)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialization_seq")
	@GenericGenerator(
			name = "specialization_seq",
			strategy = "com.mphasis.training.entities.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SP"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
	private String sId;
	@Column(nullable=false)
	private String specialization_name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Doctor doctor;	
	
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getSpecialization_name() {
		return specialization_name;
	}
	public void setSpecialization_name(String specialization_name) {
		this.specialization_name = specialization_name;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctors(Doctor doctor) {
		this.doctor = doctor;
	}	
	
}
