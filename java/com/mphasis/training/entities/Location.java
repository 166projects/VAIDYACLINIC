package com.mphasis.training.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
	@GenericGenerator(
			name = "location_seq",
			strategy = "com.mphasis.training.entities.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "LOC"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
		private String locId;
	@Column(nullable=false)
	private String location_name;
	
	@OneToMany(mappedBy="location",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Clinic> clinics;
	
	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public List<Clinic> getClinics() {
		return clinics;
	}
	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}
	
}
