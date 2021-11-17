package com.pjt.ex22.exhibit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pjt.ex22.exhibit.*;
import com.pjt.ex22.exhibit.service.ExhibitService;

@Controller
public class ExhibitController {

	@Autowired
	ExhibitService service;
	
	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView allSearch() {
	
		List<Exhibit> exList = service.exhibitAllSearch();
		ModelAndView mav = new ModelAndView();
		
		if(exList.isEmpty()) {
			mav.addObject("exList", null);
			mav.addObject("exhibit", null);
			mav.setViewName("/main");
		}
		else {
			mav.addObject("exList", exList);
			mav.addObject("exhibit", null);
			mav.setViewName("/main");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/exhibit", method= RequestMethod.GET)
	public ModelAndView search(Exhibit ex) {
		Exhibit exhibit = service.exhibitSearch(ex);
		List<Exhibit> exList = service.exhibitAllSearch();
		
		ModelAndView mav = new ModelAndView();
		
		if(exhibit == null) { // 검색 액션이 없을 때
			mav.addObject("exList", exList);
			mav.addObject("exhibit", new Exhibit());
			mav.setViewName("/main");
		} else {
			mav.addObject("exList", exList);
			mav.addObject("exhibit", exhibit);
			mav.setViewName("/main");
		}
		return mav;
	}
	
	
	
	
	
}
