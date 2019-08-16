package com.mphasis.training.dao;

import com.mphasis.training.entities.Member;

public interface LoginDao {

	public Member LoginImpl(String email, String password); 
}
