package com.pjt.ex22.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt.ex22.member.Member;
import com.pjt.ex22.member.dao.MemberDao;

//@Repository, @Component
//@Service("memService") // �ڵ����� MemberService ��ü�� ������ �����̳� ���
@Service
public class MemberService implements IMemberService{
	
	@Autowired
	MemberDao dao;
	
	// ȸ�� ����
	@Override
	public int memberRegister(Member member) {
		// TODO Auto-generated method stub
		return dao.memberInsert(member);
	}

	// ȸ�� �˻�
	@Override
	public Member memberSearch(Member member) {
		// TODO Auto-generated method stub
		return dao.memberSelect(member);
	}

	// ȸ������ ����
	@Override
	public int memberModify(Member member) {
		// TODO Auto-generated method stub
		return dao.memberUpdate(member);
	}

	// ȸ�� ����
	@Override
	public int memberRemove(Member member) {
		// TODO Auto-generated method stub
		return dao.memberDelete(member);
	}
	
	// ���� ����
	@Override
	public int memberIdentify(Member member) {
		return dao.memberExist(member);
	}
	
	// ��� �缳��
	@Override
	public int setPassword(Member member) {
		return dao.setMemPw(member);
	}
	
	// ���̵� �ߺ� Ȯ��
	@Override
	public int DuplicateIdCheck(Member member) {
		return dao.existMemId(member);
	}
}
