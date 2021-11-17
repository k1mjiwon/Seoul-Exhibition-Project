package com.pjt.ex22.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.ex22.member.Member;
import com.pjt.ex22.member.service.MemberService;


@Controller
@RequestMapping("/member") 
public class MemberController {

	@Autowired
	MemberService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	

	// ȸ������ ���
	@RequestMapping("/memJoinForm")
	public String memJoinForm(Member member) {
		return "/memJoinForm";
	}

	// ȸ�� ����
	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public ModelAndView memJoin(Member member) throws DuplicateKeyException {
		ModelAndView mav = new ModelAndView();
		int idcheck = service.DuplicateIdCheck(member);
		
		if(idcheck != 0) {
			mav.addObject("res", "duplicate");
			mav.setViewName("/memJoinForm");
		} else if(idcheck == 0) {
			int result = service.memberRegister(member);
			if(result == 0) {
				mav.addObject("res", "fail");
				mav.setViewName("/memJoinForm");
			} else {
				mav.addObject("res", "success");
				mav.setViewName("/memJoinForm");
			}
		}
		return mav;
	}
	
	// ȸ������ ���
	@RequestMapping("/memLoginForm")
	public String memLoginForm(Member member) {
		return "/memLoginForm";
	}

	// īī�� �α��� (�����ڵ� ��û �� ����ڿ��� �ڵ� ���޹ޱ�)
	// ���� ����: �����ڵ�� ��ū ����, ��ū���� API ȣ��
	@RequestMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) {
		return "īī�� ���� �ڵ尪: " + code;
	}
	
	// �α���
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public ModelAndView memLogin(Member member, Model model, HttpSession session, HttpServletResponse response) {
		
		Member m = service.memberSearch(member);
		ModelAndView mav = new ModelAndView();
		
		
		if(m == null) {
			mav.addObject("res", "fail");
			mav.setViewName("/memLoginForm");
		}
		else {
			// HttpSession session = request.getSession();
			session.setAttribute("member", m); // ���� ����
			
			Cookie cookie = new Cookie("memId", m.getMemId()); // ��Ű ����
			cookie.setMaxAge(30*60); // seconds (��) ����
			response.addCookie(cookie);

			mav.addObject("res", "success");
			mav.addObject("member", member);
			
			mav.setViewName("/memLoginForm");
		}
		
		return mav;
	}
	
	// �α׾ƿ�
	@RequestMapping(value="/memLogout")
	public ModelAndView memLogout(Member member, HttpServletRequest request, HttpSession session, 
							@CookieValue(value="memId", required=false) Cookie cookie) {
							// required=false : memId ��� ��Ű�� ��� ���� �߻� x
		
		ModelAndView mav = new ModelAndView();
		
		if(cookie != null) {
			cookie.setMaxAge(0); // ��Ű ����
		}
		session.invalidate(); // == session.setAttribute("member", null);
		mav.addObject("log", "out");
		mav.setViewName("/header");
		return mav;
	}
	
	// ȸ������ ���� ���
	@RequestMapping("/memModifyForm")
	public ModelAndView memModifyForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// �α����ߴ� ������ �����Ǿ��ִٸ�
		Member member = (Member)session.getAttribute("member");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("member", service.memberSearch(member));
		mav.setViewName("/memModifyForm");
		
		return mav;
	}
	
	// ȸ������ ����
	@RequestMapping(value="/memModify", method=RequestMethod.POST)
	public ModelAndView memModify(Member member, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
//		HttpSession session = request.getSession();
		
		int mem = service.memberModify(member);
		
		if(mem == 0) {
			mav.addObject("res", "fail");
			mav.setViewName("/memModifyForm");
		}
		else {
			mav.addObject("res", "success");
			mav.setViewName("/memModifyForm");
		}
		
		return mav;
	}
	
	// ȸ������ ���� ���
	@RequestMapping("/memDeleteForm")
	public ModelAndView memDeleteForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		mav.addObject("member", member);
		mav.setViewName("/memDeleteForm");
		
		return mav;
	}
	
	// ȸ�� Ż��
	@RequestMapping(value="/memDelete", method=RequestMethod.POST)
	public ModelAndView memDelete(Member member, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		int result = service.memberRemove(member);
		
		if(result == 0) {
			mav.addObject("res", "fail");
			mav.setViewName("/memDeleteForm");
		}
		else {
			HttpSession session = request.getSession();
			session.invalidate();
	
			mav.addObject("res", "success");
			mav.setViewName("/memDeleteForm");
		}
		return mav;
	}
	
	// ���ã�� ���
	@RequestMapping("/memFindForm")
	public String memFindForm(Member member) {
		return "/memFindForm";
	}
	
	// ��й�ȣ ã��(���� ����)
	@RequestMapping(value="/memFind", method=RequestMethod.POST)
	public ModelAndView memFind(Member member, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.memberIdentify(member);
		
		if(result == -1) {
			mav.addObject("res", "no");
			mav.setViewName("/memFindForm"); // �������� �ʴ� ���̵��Դϴ�.
		} else if(result == 0) {
			mav.addObject("res", "fail");
			mav.setViewName("/memFindForm"); // �Է��Ͻ� ������ ���� �ʽ��ϴ�.
		} else {
			mav.setViewName("/memModifyPass"); // ��� �����ϴ� ȭ������
		}
		return mav;
	}
	
	// ��й�ȣ �缳��
	@RequestMapping(value="/memSetPass", method=RequestMethod.POST)
	public ModelAndView memSetPass(Member member, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();		
		int result = service.setPassword(member);
		
		if(result == 0) {
			mav.addObject("set", "fail");
			mav.setViewName("/memModifyPass");
		} else {
			mav.addObject("set", "success");
			mav.setViewName("/memModifyPass");
		}
		return mav;
	}
	
}
