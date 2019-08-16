package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Role;

public interface RoleDao {
	public void insertRole(Role role);
	public List<Role> getRoles();
}
