package com.pjt.ex22.member.service;

import com.pjt.ex22.member.Member;

public interface IMemberService {
	int memberRegister(Member member);
	Member memberSearch(Member member);
	int memberModify(Member member);
	int memberRemove(Member member);
	int memberIdentify(Member member);
	int setPassword(Member member);
	int DuplicateIdCheck(Member member);
}
