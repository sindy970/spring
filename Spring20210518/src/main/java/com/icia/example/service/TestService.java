package com.icia.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.example.dao.TestDao;

@Service
public class TestService {
	
//	TestService 클래스는 com.icis.example.service패키지에 소속되어 있고,
//	TestDAO클래스를 com.icia.example.dao 패키지에 소속되어 있음.
//	두 클래스는 서로 다른 패키지에 소속되어 있기 때문에 import를 해줘야 사용이 가능함
	@Autowired
	private TestDao tdao;
	
	public void method1() {
		System.out.println("method1 호출됨");
	}
	
//	HomeController.java에서 데이터 받아오기
	public void method2(String data1) {
		System.out.println("method2호출됨");
		System.out.println(data1);
//		hello.jsp -> HomeController로 부터 받은 data1을 TestDAO클래스의 daoMethod1()으로 전달
		tdao.daoMethod1(data1);
	}
	
}
