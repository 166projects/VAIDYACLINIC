package com.mphasis.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.training.bo.DoctorBo;
import com.mphasis.training.entities.Clinic;
import com.mphasis.training.entities.Member;
import com.mphasis.training.entities.Role;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	DoctorBo doctorBo;

	public Member insertMember(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(member);
		tr.commit();
		return member;
//		session.setProperty("mId", member.getmId());
	}

	public void updateMember(Member member) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Member member1 = (Member) session.get(Member.class, member.getmId());
		member1.setMember_address(member.getMember_address());
		member1.setContact(member.getContact());
		member1.setPassword(member.getPassword());
		member1.setEmail(member.getEmail());
		session.update(member1);
		tr.commit();

	}

	public void deleteMember(String mid) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Member member = (Member) session.get(Member.class, mid);
		session.delete(member);
		tr.commit();
	}

	public List<Member> getMember() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Inside Dao");
		List<Member> members = session.createCriteria(Member.class).list();
		tr.commit();
		return members;

	}

}
