package com.pjt.ex22.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.FileCopyUtils;

import com.pjt.ex22.board.service.BoardService;
import com.pjt.ex22.member.Member;
import com.pjt.ex22.member.service.MemberService;
import com.pjt.ex22.board.Board;


@Controller
@RequestMapping("/board") 
public class BoardController {
	@Autowired
	BoardService service;
	@Autowired
	ServletContext context;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	// 게시물 작성양식
	@RequestMapping("/brdWriteForm")
	public String brdWriteForm(Board board) {
		return "/brdWriteForm";
	}
	
	// 게시물 작성
	@RequestMapping(value="/brdWrite", method=RequestMethod.POST)
	public ModelAndView brdWrite(@Validated Board board, BindingResult res, HttpServletRequest request) throws IllegalStateException, IOException{
		String bid = request.getParameter("bid");
		// brdWriteForm.jsp 에서 hidden으로 받는 input을 가져와 bid 변수에 넣음
		board.setBid(bid);
		// board의 bid를 input으로 받은 bid로 변경
		
		MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request; // 암시적 형변환
		MultipartFile multipartFile = mpRequest.getFile("bfile"); // form에서 받은 bfile을 multipartFile에 저장
		
		if(multipartFile != null && !multipartFile.isEmpty()) {
			String uploadPath = "C:\\Project\\exhibit_project\\src\\main\\webapp\\resources\\temp\\"; // multipartFile을 저장할 경로 지정
	
			String fileName = multipartFile.getOriginalFilename(); // multipartFile을 저장할 이름 지정
	
			multipartFile.transferTo(new File(uploadPath + fileName)); // 위에서 지정한 경로와 이름으로 multipartFile 저장
			// C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ex22-db-connectionPool\WEB-INF\temp
			board.setBfile(fileName.toLowerCase());
		}
		
		int maxBno = service.CountMaxBno(); // 마지막 게시물 번호
		// 만약 게시물 번호가 없다면 기본값 1 지정
		board.setBno(maxBno + 1);
		Board boards = service.boardCreate(board);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", boards);
		mav.setViewName("brdWriteOk");
		
		return mav;
	}

	// 게시글 목록
	@RequestMapping("/brdList")
	public ModelAndView brdList(Board board) {
		List<Board> list = service.listAll();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", list);
		
		mav.setViewName("/brdList");
		
		return mav;
	}
	
	// 게시글 상세 조회
	@RequestMapping("/brdRead")
	public ModelAndView brdRead(HttpSession session, Board bno) {
		Board boards = service.boardRead(bno);

		// 조회수 증가 처리
		service.boardUpCnt(bno, session);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("board", boards);
		
		mav.setViewName("brdWriteOk");
		
		return mav;
	}
	
	// 게시글 수정 양식
	@RequestMapping("/brdModifyForm")
	public ModelAndView brdModifyForm(HttpServletRequest request, Board board) {
		Board boards = service.boardRead(board);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("board", boards);
		
		mav.setViewName("/brdModifyForm");
		
		return mav;
	}
	
	// 게시글 수정
	@RequestMapping("/brdModify")
	public ModelAndView brdModify(Board board) {
		Board boards = service.boardModify(board);	
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("board", boards);
		
		mav.setViewName("/brdWriteOk");
		
		return mav;
	}
	
	// 게시글 삭제
	@RequestMapping("/brdDelete")
	public String brdDelete(Board board, Model model) {
		//정말로 삭제하겠습니까? 문구 띄우기 alert
		service.boardRemove(board);
		
		List<Board> list = service.listAll();
		
		model.addAttribute("list", list);

		return "/brdList";
	}
	
}
