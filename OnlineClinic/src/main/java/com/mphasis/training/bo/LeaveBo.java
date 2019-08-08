package com.mphasis.training.bo;

import com.mphasis.training.entities.Leave;

public interface LeaveBo {

	public void insertLeave(Leave leave);
	public void approveLeave(Leave leave);
	public void denyLeave(Leave leave);
	
}


