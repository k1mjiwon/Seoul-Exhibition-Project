package com.pjt.ex22.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;

import com.pjt.ex22.member.Member;
import com.mchange.v2.c3p0.ComboPooledDataSource;


@Repository // 자동으로 MemberDao 객체가 스프링 컨테이너 담김
public class MemberDao implements IMemberDao {

	private JdbcTemplate template;
	
	@Autowired
	public MemberDao(ComboPooledDataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	// 회원 등록
	@Override
	public int memberInsert(Member member) {
		// TODO Auto-generated method stub
		String sql = "insert into member (memId, memPw, memMail, memPhone1, memPhone2, memPhone3) "
				+ "values (?, ?, ?, ?, ?, ?)";

		int result = template.update(sql, member.getMemId(), member.getMemPw(),
				member.getMemMail(), member.getMemPhone1(), 
				member.getMemPhone2(), member.getMemPhone3());
		
		return result;
	}

	// 회원 검색
	@Override
	public Member memberSelect(Member member) {
		// TODO Auto-generated method stub
		
	      String sql = "select * from member where memId = ? and memPw = ?";
	      List<Member> members;

	      members = template.query(sql, new RowMapper<Member>() {// 결과 테이블 행 맵핑

	         @Override
	         public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	            Member mem = new Member();
	            mem.setMemId(rs.getString("memId"));
	            mem.setMemPw(rs.getString("memPw"));
	            mem.setMemMail(rs.getString("memMail"));
	            mem.setMemPhone1(rs.getString("memPhone1"));
	            mem.setMemPhone2(rs.getString("memPhone2"));
	            mem.setMemPhone3(rs.getString("memPhone3"));
	            return mem;
	         }

	      }, member.getMemId(), member.getMemPw());
	      
	      if(members.isEmpty()) return null;
	      return members.get(0);
	}
	
	// 회원정보 수정
	@Override
	public int memberUpdate(Member member) {
		// TODO Auto-generated method stub
//		int res = memberIdentify(member);

		if (memberSelect(member) == null) {
			return 0;
		} else {
			String sql = "update member set memPw = ?, memMail = ?, memPhone1 = ?, memPhone2 = ?, memPhone3 = ? "
					+ "where memId = ?";
			int result = template.update(sql, member.getMemPw_aft(), member.getMemMail(), member.getMemPhone1(),
					member.getMemPhone2(), member.getMemPhone3(), member.getMemId());
			return result;
		}
	}

	// 회원 삭제
	@Override
	public int memberDelete(Member member) {
		// TODO Auto-generated method stub
		String sql = "delete member where memId = ? and memPw = ?";
		int result = template.update(sql, member.getMemId(),member.getMemPw());
		return result;
	}
	
	// 아이디 존재 유무 확인
	public int existMemId(Member member) {
		String sql = "select count(memId) from member where memId = ?";
		int result = template.queryForInt(sql, member.getMemId());
		return result;
	}
	
	// 본인 확인
	public int memberExist(Member member) {
		if(existMemId(member) == 0) { // 해당 아이디가 존재하지 않으면
			return -1;
		} else {
			String sql = "select count(*) from member where memId = ? and memMail = ?";
			int result = template.queryForInt(sql, member.getMemId(), member.getMemMail());
			return result; // 아이디와 메일이 동일하지 않으면 0, 동일하면 1
		}
	}
	
	
	// 비밀번호 재설정
	@Override
	public int setMemPw(Member member) {
		String sql = "update member set memPw = ? where memId = ?";
		int result = template.update(sql, member.getMemPw(), member.getMemId());
		return result;
	}

}
