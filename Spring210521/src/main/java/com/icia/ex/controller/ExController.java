package com.icia.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.ex.dto.ExDTO;
import com.icia.ex.service.ExService;

@Controller
public class ExController {
	
	@Autowired
	private ExService es;
	
	private ModelAndView mav;
	
	@RequestMapping(value = "/insertpage")
	public String insertpage() {
		System.out.println("insert.jsp 호출");
		return "insert";
	}
	
//	@RequestMapping(value = "/insert")
//	public void insert(@RequestParam("col1") String col1, @RequestParam("col2") String col2, @RequestParam("col3") String col3) {
//		System.out.println(col1);
//		System.out.println(col2);
//		System.out.println(col3);
////		회원가입시 아이다,비밀번호,이름,전화번호,이메일,성별,주소 등이 있는데 입력되는 값이 많아질수록 requestparam의 갯수가 많아짐으로 효율적이지 않다.
//
//		//매개변수를 그대로 전당하는 방법
//		es.insert1(col1,col2,col3);
//		
////		dto를 이용하여 ExService.insert2메소드로 전달하는 방법
////		dto객체 선언
//		ExDTO dto = new ExDTO();
//		dto.setCol1(col1);
//		dto.setCol2(col2);
//		dto.setCol3(col3);
//		
//		es.insert2(dto);
//	}
	
	
//	@ModelAttribute : 필드를 하나하나 선언하지 않아도 dto에 있는 필드를 한번에 사용할 수 있게 해준다.
//			: dto 필드값을 알아서 담아주는 역할을 해 준다.
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute ExDTO dto) {
//		dto에 값이 제대로 담겼는지 확인을 위한 출력문이다.
		System.out.println(dto.toString());
		es.insert2(dto);
		return "home";
	}
	
	
	
	@RequestMapping(value="/select")
	public ModelAndView select() {
		System.out.println("select.jsp호출");
		mav = es.selectDB();
		return mav;
	}
	
	

}
