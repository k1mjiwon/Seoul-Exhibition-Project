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
	
	// �Խù� �ۼ����
	@RequestMapping("/brdWriteForm")
	public String brdWriteForm(Board board) {
		return "/brdWriteForm";
	}
	
	// �Խù� �ۼ�
	@RequestMapping(value="/brdWrite", method=RequestMethod.POST)
	public ModelAndView brdWrite(@Validated Board board, BindingResult res, HttpServletRequest request) throws IllegalStateException, IOException{
		String bid = request.getParameter("bid");
		// brdWriteForm.jsp ���� hidden���� �޴� input�� ������ bid ������ ����
		board.setBid(bid);
		// board�� bid�� input���� ���� bid�� ����
		
		MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request; // �Ͻ��� ����ȯ
		MultipartFile multipartFile = mpRequest.getFile("bfile"); // form���� ���� bfile�� multipartFile�� ����
		
		if(multipartFile != null && !multipartFile.isEmpty()) {
			String uploadPath = "C:\\Project\\exhibit_project\\src\\main\\webapp\\resources\\temp\\"; // multipartFile�� ������ ��� ����
	
			String fileName = multipartFile.getOriginalFilename(); // multipartFile�� ������ �̸� ����
	
			multipartFile.transferTo(new File(uploadPath + fileName)); // ������ ������ ��ο� �̸����� multipartFile ����
			// C:\Project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ex22-db-connectionPool\WEB-INF\temp
			board.setBfile(fileName.toLowerCase());
		}
		
		int maxBno = service.CountMaxBno(); // ������ �Խù� ��ȣ
		// ���� �Խù� ��ȣ�� ���ٸ� �⺻�� 1 ����
		board.setBno(maxBno + 1);
		Board boards = service.boardCreate(board);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", boards);
		mav.setViewName("brdWriteOk");
		
		return mav;
	}

	// �Խñ� ���
	@RequestMapping("/brdList")
	public ModelAndView brdList(Board board) {
		List<Board> list = service.listAll();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", list);
		
		mav.setViewName("/brdList");
		
		return mav;
	}
	
	// �Խñ� �� ��ȸ
	@RequestMapping("/brdRead")
	public ModelAndView brdRead(HttpSession session, Board bno) {
		Board boards = service.boardRead(bno);

		// ��ȸ�� ���� ó��
		service.boardUpCnt(bno, session);
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("board", boards);
		
		mav.setViewName("brdWriteOk");
		
		return mav;
	}
	
	// �Խñ� ���� ���
	@RequestMapping("/brdModifyForm")
	public ModelAndView brdModifyForm(HttpServletRequest request, Board board) {
		Board boards = service.boardRead(board);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("board", boards);
		
		mav.setViewName("/brdModifyForm");
		
		return mav;
	}
	
	// �Խñ� ����
	@RequestMapping("/brdModify")
	public ModelAndView brdModify(Board board) {
		Board boards = service.boardModify(board);	
		
		ModelAndView mav = new ModelAndView();

		mav.addObject("board", boards);
		
		mav.setViewName("/brdWriteOk");
		
		return mav;
	}
	
	// �Խñ� ����
	@RequestMapping("/brdDelete")
	public String brdDelete(Board board, Model model) {
		//������ �����ϰڽ��ϱ�? ���� ���� alert
		service.boardRemove(board);
		
		List<Board> list = service.listAll();
		
		model.addAttribute("list", list);

		return "/brdList";
	}
	
}
