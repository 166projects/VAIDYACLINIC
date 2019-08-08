package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Member;

public interface MemberDao {
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(int mid);
	public List<Member> getMember();
	
}
