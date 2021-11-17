package com.pjt.ex22.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt.ex22.board.Board;
import com.pjt.ex22.board.dao.BoardDao;

@Service
public class BoardService implements IBoardService{
	@Autowired
	BoardDao bdao;
	
	// 게시글 목록 조회
	public List<Board> listAll() {
		return bdao.boardList();
	}
	
	// 게시글 전체 페이지 확인
//	public int totalPage() {
//		return bdao.TotalRows();
//	}
	
	// 게시글 작성
	@Override
	public Board boardCreate(Board board) {
		return bdao.boardWrite(board);
	}

	// 게시글 상세보기
	@Override
	public Board boardRead(Board board) {
		return bdao.boardSelect(board);
	}
	
	// 조회수 증가
	@Override
	public int boardUpCnt(Board bno, HttpSession session) {
		return bdao.updatebcnt(bno);
	}

	// 게시글 수정
	@Override
	public Board boardModify(Board board) {
		Board boardResult = bdao.boardUpdate(board);
		if(boardResult.equals(null)) {
			return null;
		}
		return bdao.boardUpdate(board);
	}

	// 게시글 삭제
	@Override
	public int boardRemove(Board board) {
		return bdao.boardDelete(board);
	}

	@Override
	public int CountMaxBno() {
		return bdao.getMaxBno();
	}
	

}