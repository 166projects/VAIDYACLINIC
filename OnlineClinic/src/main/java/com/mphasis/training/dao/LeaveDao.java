package com.mphasis.training.dao;

import com.mphasis.training.entities.Leave;

public interface LeaveDao {
	public void insertLeave(Leave leave);
	public void approveLeave(Leave leave);
	public void denyLeave(Leave leave);

}
