package com.icia.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.study.service.StudyService;

@Controller
public class StudyController {
	
	@Autowired
	private StudyService ss;
	
//	ModelAndView : 데이터와 화면정보를 담을 수 있는 클래스 타입이다.
//	@Autowired하지 않는다.
	private ModelAndView mav;
	
//서로 다른 컨트롤레에 있다고 하더라도 주소가 같은 메소드가 있으면 오류 발생한다.
//즉 주소로 사용하는 value=에 쓰는 값은 다른 컨트롤러라 해도 중복되면 안됨
//	@RequestMapping(value="/")
//	public String home() {
//		return "home";
//	}
//HomeController.java에 이미 /의 주소값을 갔는 어노스토리가 있기 때문에 사용이 안된다.
	
	
	@RequestMapping(value = "/insertpage")
	public String insertpage() {
		return "insert";
	}
	
	@RequestMapping(value = "/insert")
	public String insertDB(@RequestParam("param1") String param1) {
		System.out.println(param1);
		ss.insertDB(param1);
		//insert가 완료되면 home.jsp출력
		return "home";
	}
	
	@RequestMapping(value ="/select")
	public ModelAndView selectDB() {
		System.out.println("컨트롤러");
		mav = ss.selectDB();
		return mav; // <== 이 mav에는 dblist를 select.jsp로 가직고 가는 내용이 담겨 있음.
	}
}
