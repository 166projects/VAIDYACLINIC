package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.LeaveDao;
import com.mphasis.training.entities.Leave;
import com.mphasis.training.webrequestview.LeaveView;

@Service
public class LeaveBoImpl implements LeaveBo {
	@Autowired
	LeaveDao leaveDao;

	public void insertLeave(Leave leave) {
		leaveDao.insertLeave(leave);
	}

	public void approveLeave(Leave leave) {
		leaveDao.approveLeave(leave);
	}

	public void denyLeave(Leave leave) {
		leaveDao.denyLeave(leave);
	}

	public void updateLeave(Leave leave) {
		leaveDao.updateLeave(leave);
	}

	public void deleteLeave(String lid) {
	leaveDao.deleteLeave(lid);	
	}

	public List<Leave> getLeaves() {
		return leaveDao.getLeaves();
	}

}
