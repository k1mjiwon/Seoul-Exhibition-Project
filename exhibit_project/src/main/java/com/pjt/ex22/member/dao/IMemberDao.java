package com.pjt.ex22.member.dao;

import com.pjt.ex22.member.Member;

public interface IMemberDao {
	int memberInsert(Member member);
	Member memberSelect(Member member);
	int memberUpdate(Member member);
	int memberDelete(Member member);
	int existMemId(Member member);
	int memberExist(Member member);
	int setMemPw(Member member);
}
