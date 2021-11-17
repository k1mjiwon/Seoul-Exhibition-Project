package com.pjt.ex22.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.pjt.ex22.board.Board;

public interface IBoardService {
	Board boardCreate(Board board);
	Board boardRead(Board board);
	Board boardModify(Board board);
	int boardRemove(Board board);
	int boardUpCnt(Board bno, HttpSession session);
	int CountMaxBno();
}
