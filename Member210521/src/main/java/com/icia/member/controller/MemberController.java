package com.icia.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;

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
	public ModelAndView memberlogin(@ModelAttribute MemberDTO member) {
	//로그인 페이지
		System.out.println("login 메소드" + member.toString());
		mav = ms.memberLogin(member);
//		member객체에는 memberlogin.jsp에서 입력한 mid, mpassword값만 담겨 있다.
		return mav;
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
	
//	로그아웃 처리 메소드
	@RequestMapping(value = "/logout")
	public String logout() {
		//로그아웃은 세션에 저장된 내용을 지운다는 개념이다. 즉,로그인한 아이디 or 비밀번호를 지운다는 개념이다.
		session.invalidate();
		//invalidate메소드는 세션에 있는 값들을 없애는 메소드 이다.
		
		return "home";
	}
	
	
	//회원정보수정
	@RequestMapping(value="/memberupdate")
	public ModelAndView update() {
		mav = ms.update();
		return mav;
	}
	
	//회원정보 수정 처리
	@RequestMapping(value = "/updateprocess")
	public ModelAndView updateProcess(@ModelAttribute MemberDTO member) {
		mav = ms.updateProcess(member);
		return mav;
	}
	
	@RequestMapping(value="/memberdelete")
	public ModelAndView memberDelete(@RequestParam("mid") String mid) {
		mav = ms.memberDelete(mid);
		return mav;
	}
}
