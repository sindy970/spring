package com.icia.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;

	@RequestMapping(value = "/joinpage")
	public String joinpage() {
		System.out.println("joinpage페이지로 이동");
		return "memberjoin";
	}
	
	@RequestMapping(value = "/memberjoin")
	public String memberjoin(@ModelAttribute MemberDTO dto) {
	//회원가입 페이지
		System.out.println(dto.toString());
		ms.memberjoinInsert(dto);
		return "home";
	}
	
	
	@RequestMapping(value = "/loginpage")
	public String loginpage() {
		System.out.println("loginpage페이지로 이동");
		return "memberlogin";
	}
	
	@RequestMapping(value = "/memberlogin")
	public String memberlogin() {
	//로그인 페이지
		return "home";
	}
	
	
//	@RequestMapping(value = "/listpage")
//	public String listpage() {
//		System.out.println("listpage페이지로 이동");
//		return "memberlist";
//	}

	@RequestMapping(value = "/listpage")
	public ModelAndView memberlist() {
		System.out.println("memberlist페이지로 이동");
		mav = ms.memberlist();
		return mav;
	}
	
}
