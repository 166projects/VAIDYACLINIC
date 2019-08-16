package com.mphasis.training.bo;

import java.util.List;

import com.mphasis.training.entities.Leave;
import com.mphasis.training.webrequestview.LeaveView;

public interface LeaveBo {

	public void insertLeave(Leave leave);
	public void approveLeave(Leave leave);
	public void denyLeave(Leave leave);
	public void updateLeave(Leave leave);
	public void deleteLeave(String lid); 
	public List<Leave> getLeaves() ;
}


