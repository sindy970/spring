package com.icia.example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.example.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	DAO클래스는 @Repository어노테이션을 붙인다.
//	Service클래스에 @Service 어노테이션을 붙인 후 controller클래스에서 
//	@Autowired를 붙여서 Service클래스 객체를 선언하면
//	매번 new를 이용하여 객체를 만들지 않고도 Service클래스의 자원(필드,메소드)을 활용 할 수 있다.
	@Autowired
	private TestService ts;
	
	//프로젝트를 실행했을 떄 hello.jsp를 띄우고, 내용은 노란배경의 빨간색으로 안녕하세요 할것
	@RequestMapping(value="/")
	public String home() {
		System.out.println("home 함수 호출 됨");
		return "hello";
	}
	
//	링크를 통해서 온 요청 처리하기
	@RequestMapping(value="/test123")
	public void test123() {
		System.out.println("test123 주소 요청");
	}
	
//	링크를 통해서 온 요청으로 welcome.jsp로 이동하기
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "welcome";
	}
	
//	welcome.jsp페이지에서 form태그를 이용하여 데이터를 주고받기
//	입력메세지로 입력받은 데이터를 받아오기
//	@RequestMapping()안에 ,를 이용하여 여러개의 값을 넣을 수 있다 그래서 method를 지정할 수 있지만 form태그의 방식과 동일한 방식으로 지정해줘야 한다.
//	method를 아무것도 지정해주지 않으면 get,post 모두 받을 수 있지만 지정을 하면 지정한 값만 받을 수 있다.
//	링크로 요청하는 것은 get방식이다.
//	@RequestMapping(value = "/welcomemsg", method = RequestMethod.GET)
	@RequestMapping(value = "/welcomemsg")
	public void welcomemsg(@RequestParam("msg") String msg, @RequestParam("msg2") String msg2) {
//		받아오는 데이터가 여러개일 경우에는 여러개의 매개변수로 받아 올 수 있다.
		System.out.println("msg내용 호출됨");
		System.out.println(msg);
		System.out.println(msg2);
	}
	
//	링크로 넘어온 파라미터 받기
	@RequestMapping(value="/linkmsg")
	public void linkmsg(@RequestParam("val1") String val1, @RequestParam("val2") String val2) {
		System.out.println(val1);
		System.out.println(val2);
	}
	
	
	
	
//	DB연동을 위한 컨트롤
	@RequestMapping(value="/insertDB")
	public void insertDB(@RequestParam("data1") String data1) {
		System.out.println(data1);
		
//		TestService클래스에 있는 method1호출
		
		/*
		 * hello.jsp에서 입력하고 저장버튼 클릭
		 * HomeController의 insertDB메소드 호출되고
		 * 여기서 TestService의 method1메소드 호출됨
		 * 
		 * hello.jsp -> HomeController -> TestService -> TestDAO -> DataBase 
		 */
//		ts.method1();
		
//		hello.jsp에서 넘어온 데이터를 TestService로 보냄
//		데이터를 넘겨서 method1에서 해당 데이터를 sysout으로 출력하기
		ts.method2(data1);
	}
}
