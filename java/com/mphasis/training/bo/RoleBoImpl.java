package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.RoleDao;
import com.mphasis.training.entities.Role;

@Service
public class RoleBoImpl implements RoleBo {

	@Autowired
	RoleDao roleDao;

	public void insertRole(Role role) {
		roleDao.insertRole(role);
	}

	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

}
