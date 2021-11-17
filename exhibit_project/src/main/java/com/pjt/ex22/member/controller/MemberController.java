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
	

	// 회원가입 양식
	@RequestMapping("/memJoinForm")
	public String memJoinForm(Member member) {
		return "/memJoinForm";
	}

	// 회원 가입
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
	
	// 회원가입 양식
	@RequestMapping("/memLoginForm")
	public String memLoginForm(Member member) {
		return "/memLoginForm";
	}

	// 카카오 로그인 (인증코드 요청 및 사용자에게 코드 전달받기)
	// 남은 구현: 인증코드로 토큰 전달, 토큰으로 API 호출
	@RequestMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) {
		return "카카오 인증 코드값: " + code;
	}
	
	// 로그인
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
			session.setAttribute("member", m); // 세션 생성
			
			Cookie cookie = new Cookie("memId", m.getMemId()); // 쿠키 생성
			cookie.setMaxAge(30*60); // seconds (초) 단위
			response.addCookie(cookie);

			mav.addObject("res", "success");
			mav.addObject("member", member);
			
			mav.setViewName("/memLoginForm");
		}
		
		return mav;
	}
	
	// 로그아웃
	@RequestMapping(value="/memLogout")
	public ModelAndView memLogout(Member member, HttpServletRequest request, HttpSession session, 
							@CookieValue(value="memId", required=false) Cookie cookie) {
							// required=false : memId 라는 쿠키가 없어도 예외 발생 x
		
		ModelAndView mav = new ModelAndView();
		
		if(cookie != null) {
			cookie.setMaxAge(0); // 쿠키 삭제
		}
		session.invalidate(); // == session.setAttribute("member", null);
		mav.addObject("log", "out");
		mav.setViewName("/header");
		return mav;
	}
	
	// 회원정보 수정 양식
	@RequestMapping("/memModifyForm")
	public ModelAndView memModifyForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		// 로그인했던 세션이 유지되어있다면
		Member member = (Member)session.getAttribute("member");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("member", service.memberSearch(member));
		mav.setViewName("/memModifyForm");
		
		return mav;
	}
	
	// 회원정보 수정
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
	
	// 회원정보 삭제 양식
	@RequestMapping("/memDeleteForm")
	public ModelAndView memDeleteForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		mav.addObject("member", member);
		mav.setViewName("/memDeleteForm");
		
		return mav;
	}
	
	// 회원 탈퇴
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
	
	// 비번찾기 양식
	@RequestMapping("/memFindForm")
	public String memFindForm(Member member) {
		return "/memFindForm";
	}
	
	// 비밀번호 찾기(본인 인증)
	@RequestMapping(value="/memFind", method=RequestMethod.POST)
	public ModelAndView memFind(Member member, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		int result = service.memberIdentify(member);
		
		if(result == -1) {
			mav.addObject("res", "no");
			mav.setViewName("/memFindForm"); // 존재하지 않는 아이디입니다.
		} else if(result == 0) {
			mav.addObject("res", "fail");
			mav.setViewName("/memFindForm"); // 입력하신 정보가 맞지 않습니다.
		} else {
			mav.setViewName("/memModifyPass"); // 비번 설정하는 화면으로
		}
		return mav;
	}
	
	// 비밀번호 재설정
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
