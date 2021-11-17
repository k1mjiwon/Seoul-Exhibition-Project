package com.pjt.ex22.board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pjt.ex22.board.Board;


@Repository // 스프링 컨테이너에 BoardDao 객체 담김
public class BoardDao implements IBoardDao{
	
	private JdbcTemplate template;
	
	@Autowired
	public BoardDao(ComboPooledDataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	
	// 게시물 목록
	@Override
	public List<Board> boardList() {
		// TODO Auto-generated method stub
		List<Board> boards;
		
		String sql = "select bno, btitle, bcnt, bdate, bid from board order by bno desc";
		
		boards = template.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Board brd = new Board();
	            brd.setBno(rs.getInt("bno"));
	            brd.setBtitle(rs.getString("btitle"));
	            brd.setBcnt(rs.getInt("bcnt"));
	            brd.setBdate(rs.getTimestamp("bdate"));
	            brd.setBid(rs.getString("bid"));
	            return brd;
			}
			
		});
	    
		if(boards.isEmpty()) return null;
		return boards;
	}
	
	// 게시물 총 개수 확인
//	@Override
//	public int TotalRows() {
//		int result = 0;
//		String sql = "Select count(bno) from board";
//		result = template.queryForObject(sql, Integer.class);
//		return result;
//	}
	
	
	// 게시물 작성
	@Override
	public Board boardWrite(Board board) {
		// TODO Auto-generated method stub

		String sql = "Insert into board (bno, btitle, btext, bid, bdate, bcnt, bfile) "
				+ "values (?, ?, ?, ?, SYSDATE, 0, ?)";
		
		int result = template.update(sql, board.getBno(), board.getBtitle(), board.getBtext(), board.getBid(), board.getBfile());
				// board.getBfile이 아닌 board.getFile (multipartFile) 이여야 하는지?

		Board boardResult = boardSelect(board);

		return boardResult;
	}

	// 게시물 상세보기
	@Override
	public Board boardSelect(Board board) {
		// TODO Auto-generated method stub
		List<Board> boards;
		
		String sql = "select * from board where bno=?";
		
		boards = template.query(sql, new RowMapper<Board>() {// 결과 테이블 행 맵핑

	         @Override
	         public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
	            // TODO Auto-generated method stub
	            Board brd = new Board();
	            brd.setBno(rs.getInt("bno"));
	            brd.setBtitle(rs.getString("btitle"));
	            brd.setBtext(rs.getString("btext"));
	            brd.setBcnt(rs.getInt("bcnt"));
	            brd.setBdate(rs.getTimestamp("bdate"));
	            brd.setBid(rs.getString("bid"));
	            brd.setBfile(rs.getString("bfile"));

	            return brd;
	         }

	      }, board.getBno());
	      
	      if(boards.isEmpty()) return null;
	      return boards.get(0);
	}
	
	// 조회수 증가
		@Override
		public int updatebcnt(Board board) {
			// TODO Auto-generated method stub
			String sql = "update board set bcnt = bcnt + 1 where bno=?";
			int result = template.update(sql, board.getBno());
			return result;
		}
		
	// 게시물 수정
	@Override
	public Board boardUpdate(Board board) {
		// TODO Auto-generated method stub
		String sql  = "update board set btitle=?, btext=?, bfile=? where bno=?";
		
		int result = template.update(sql, board.getBtitle(), board.getBtext(), board.getBfile(), board.getBno());
		
		Board boards = boardSelect(board);
		
		return boards;
	}

	// 게시물 삭제
	@Override
	public int boardDelete(Board board) {
		// TODO Auto-generated method stub
		String sql = "delete from board where bno=?";
		int result = template.update(sql, board.getBno());
		return result;
	}

	// 마지막 게시글 번호 구하기
	public int getMaxBno() {
		String sql = "select max(bno) from board";
		int maxBno = template.queryForObject(sql, Integer.class);
		return maxBno;
	}
	
}