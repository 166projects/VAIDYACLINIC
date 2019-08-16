package com.mphasis.training.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mphasis.training.entities.Appointment;
import com.mphasis.training.entities.Role;

public interface RoleBo {

	public void insertRole(Role role);
	public List<Role> getRoles();
	
}


