package com.pjt.ex22.board.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pjt.ex22.board.Board;
import com.pjt.ex22.member.Member;

public interface IBoardDao {
	public Board boardWrite(Board board);  // 게시물 작성
	public Board boardSelect(Board board); // 게시물 선택
	public Board boardUpdate(Board board);  // 게시물 수정
	public int boardDelete(Board board);  // 게시물 삭제
	public int updatebcnt(Board board);  // 조회수 증가
	List<Board> boardList(); // 전체 목록보기
	public int getMaxBno(); // 마지막 게시글 번호 구하기
}
