package com.pjt.ex22.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt.ex22.member.Member;
import com.pjt.ex22.member.dao.MemberDao;

//@Repository, @Component
//@Service("memService") // 자동으로 MemberService 객체가 스프링 컨테이너 담김
@Service
public class MemberService implements IMemberService{
	
	@Autowired
	MemberDao dao;
	
	// 회원 가입
	@Override
	public int memberRegister(Member member) {
		// TODO Auto-generated method stub
		return dao.memberInsert(member);
	}

	// 회원 검색
	@Override
	public Member memberSearch(Member member) {
		// TODO Auto-generated method stub
		return dao.memberSelect(member);
	}

	// 회원정보 수정
	@Override
	public int memberModify(Member member) {
		// TODO Auto-generated method stub
		return dao.memberUpdate(member);
	}

	// 회원 삭제
	@Override
	public int memberRemove(Member member) {
		// TODO Auto-generated method stub
		return dao.memberDelete(member);
	}
	
	// 본인 인증
	@Override
	public int memberIdentify(Member member) {
		return dao.memberExist(member);
	}
	
	// 비번 재설정
	@Override
	public int setPassword(Member member) {
		return dao.setMemPw(member);
	}
	
	// 아이디 중복 확인
	@Override
	public int DuplicateIdCheck(Member member) {
		return dao.existMemId(member);
	}
}
