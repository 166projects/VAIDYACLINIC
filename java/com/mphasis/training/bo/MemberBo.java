package com.mphasis.training.bo;

import java.util.List;

import com.mphasis.training.entities.Member;

public interface MemberBo {

	public Member insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(String mId);
	public List<Member> getMember();
		
}

	
