package com.mphasis.training.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable=true)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
	@GenericGenerator(
			name = "flight_seq",
			strategy = "com.mphasis.training.entities.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ME"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")})
		private String mId;
	
	@Column(nullable=false)
	private String firstName;

	private String lastName;
	@Column(nullable=false)
	private String gender;

	@Column(unique = true,nullable=false)
	private String contact;

	@Column(nullable=false)
	private String password;

	@Column(unique = true,nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String member_address;

	@OneToOne(mappedBy = "member")
	private Role role;

	@OneToOne(mappedBy = "member")
	private Doctor doctor;

	@OneToOne(mappedBy = "member")
	private Patient patient;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return member_address;
	}

	public void setAddress(String address) {
		this.member_address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", contact=" + contact + ", password=" + password + ", email=" + email + ", address=" + member_address
				+ ", role=" + role + ", doctor=" + doctor + ", patient=" + patient + "]";
	}

}
