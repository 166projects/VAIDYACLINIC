package com.mphasis.training.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
	@GenericGenerator(
			name = "role_seq",
			strategy = "com.mphasis.training.entities.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "R"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
		private String rId;

	@Column(nullable=false)
	private String role_name;
	
//	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//	@JsonIgnore
//	private List<Member> members;


	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

//	public List<Member> getMembers() {
//		return members;
//	}
//
//	public void setMembers(List<Member> members) {
//		this.members = members;
//	}
	
	

}
