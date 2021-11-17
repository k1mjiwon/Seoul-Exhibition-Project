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
	
	// �Խñ� ��� ��ȸ
	public List<Board> listAll() {
		return bdao.boardList();
	}
	
	// �Խñ� ��ü ������ Ȯ��
//	public int totalPage() {
//		return bdao.TotalRows();
//	}
	
	// �Խñ� �ۼ�
	@Override
	public Board boardCreate(Board board) {
		return bdao.boardWrite(board);
	}

	// �Խñ� �󼼺���
	@Override
	public Board boardRead(Board board) {
		return bdao.boardSelect(board);
	}
	
	// ��ȸ�� ����
	@Override
	public int boardUpCnt(Board bno, HttpSession session) {
		return bdao.updatebcnt(bno);
	}

	// �Խñ� ����
	@Override
	public Board boardModify(Board board) {
		Board boardResult = bdao.boardUpdate(board);
		if(boardResult.equals(null)) {
			return null;
		}
		return bdao.boardUpdate(board);
	}

	// �Խñ� ����
	@Override
	public int boardRemove(Board board) {
		return bdao.boardDelete(board);
	}

	@Override
	public int CountMaxBno() {
		return bdao.getMaxBno();
	}
	

}