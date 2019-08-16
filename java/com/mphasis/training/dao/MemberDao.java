package com.mphasis.training.dao;

import java.util.List;

import com.mphasis.training.entities.Member;

public interface MemberDao {
	public Member insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(String mid);
	public List<Member> getMember();
	
}
