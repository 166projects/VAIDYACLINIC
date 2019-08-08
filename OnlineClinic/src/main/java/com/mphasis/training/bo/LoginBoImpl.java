package com.mphasis.training.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.LoginDao;
import com.mphasis.training.entities.Member;
@Service
public class LoginBoImpl implements LoginBo {

	@Autowired
	LoginDao loginDao;
	

	public Member LoginImpl(String email, String password) {
		return loginDao.LoginImpl(email, password);
	}

}
