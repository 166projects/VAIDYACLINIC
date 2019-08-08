package com.mphasis.training.bo;

import com.mphasis.training.entities.Member;

public interface LoginBo {

	public Member LoginImpl(String email, String password) ;
}
