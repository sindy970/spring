package com.icia.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 컨트롤러 클래스로 지정하기 위한 어노테이션이다. 대소문자 구분해줘야 한다.
@Controller
public class MainController {
	
	//기본주소를 처리하기 위한 메소드 정의
	//@RequestMapping : 주소갑을 받기 위한 어노테이션
	//	형식 : @RequestMapping(value= "원하는 주소형태")
	//		/ => 기본주소의 형태이다.
//	@RequestMapping(value = "/")
//	public void home() {
//		System.out.println("home 메소트 호출됨");
//	}
	//value값이 즉,같은 주소값을 가지는  메소드가 존재하면 ambiguous mapping이라는 모호하다는 오류가 발생한다.

	// 기본주소 요청이 왔을 때 home.jsp를 출력하기 위한 메소드 정의
	@RequestMapping(value = "/")
	public String home1() {
		System.out.println("home1 메소드 호출");
		return "home";
		//home.jsp를 출력하는 역할을 함 즉, home.jsp를 띄워라라는 의미이다.
	}
		
	// /a라는 주소 요청이 왔을 때 처리하기 위한 메소드 정의
	// 메소드 이름은 homea라고 하고 메소드가 호출됐을 때 homea 메소드 호출이라고 sysout 출력
	// @RequestMapping(value = "a") 의 형태도 내가 원하는대로 실행이 된다.
	@RequestMapping(value = "/a")
	public void homea() {
		System.out.println("homea 메소드 호출");
	}
	
	// /abc라는 주소 요청이 왔을 때 abc.jsp를 출력하는 메소드 정의
	// abc.jsp에서는 파란색으로 Hello world를 출력
	@RequestMapping(value = "/abc")
	public String abc() {
		System.out.println("abc 함수 호출");
		return "abc";
	}
	
	//form태그를 통해 전송된 값을 처리할 메소드 정의
	@RequestMapping(value = "/paramtest")
	public void home3(@RequestParam("param1") String a) {
  		// RequestParam어노테이션 : 화면(jsp)으로 부터 전송된 파라미터에 담긴 값을 꺼내는 역할
		// .jsp파일에서 name에 쓴 변수이름을 RequestParam("name변수이름")의 형식으로 사용하면 된다.
		System.out.println("home2 메소드 호출");
		System.out.println(a);
		// sysout으로 출력한 값은 이클립스내에 콘솔창에서 출력이 된다.
	}
}
