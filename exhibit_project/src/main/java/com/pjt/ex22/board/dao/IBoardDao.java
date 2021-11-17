package com.pjt.ex22.board.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pjt.ex22.board.Board;
import com.pjt.ex22.member.Member;

public interface IBoardDao {
	public Board boardWrite(Board board);  // �Խù� �ۼ�
	public Board boardSelect(Board board); // �Խù� ����
	public Board boardUpdate(Board board);  // �Խù� ����
	public int boardDelete(Board board);  // �Խù� ����
	public int updatebcnt(Board board);  // ��ȸ�� ����
	List<Board> boardList(); // ��ü ��Ϻ���
	public int getMaxBno(); // ������ �Խñ� ��ȣ ���ϱ�
}
