package com.mphasis.training.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.training.dao.MemberDao;
import com.mphasis.training.entities.Member;

@Service
public class MemberBoImpl implements MemberBo {
	@Autowired
	MemberDao memberDao;

	public Member insertMember(Member member) {
		return memberDao.insertMember(member);
	}

	public void updateMember(Member member) {
		memberDao.updateMember(member);
	}

	public void deleteMember(String mid) {
		memberDao.deleteMember(mid);
	}

	public List<Member> getMember() {
		return memberDao.getMember();
	}

	
}
