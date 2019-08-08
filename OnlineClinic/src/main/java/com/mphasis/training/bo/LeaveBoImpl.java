package com.mphasis.training.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.LeaveDao;
import com.mphasis.training.entities.Leave;
@Service
public class LeaveBoImpl implements LeaveBo {
@Autowired
LeaveDao leaveDao;
	public void insertLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.insertLeave(leave);
	}

	public void approveLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.approveLeave(leave);
	}

	public void denyLeave(Leave leave) {
		// TODO Auto-generated method stub
		leaveDao.denyLeave(leave);
	}

}
