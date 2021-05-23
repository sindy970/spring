package com.icia.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
//	DAO클래스의 역할
//	자바와 DB를 연결해주는 Mybatis라는 프레임워크를 활용하여 필요한 쿼리를 호출하는 역할을 
//	하는 쿼리수행결과를 Service클래스로 리턴
	
	//SqlSessionTemplate : mybatis에서 제공하는 클래스이다.
//				: 이클래스에는 DB의 DRUD와 관련된 메소드를 제공한다.
	@Autowired
	private SqlSessionTemplate sql;
	
	
	public void daoMethod1(String data1) {
		System.out.println("TestDAO호출");
		System.out.println(data1);
		
//		DB의 Testtable에 data1을 insert하도록 insert메소드 사용
		sql.insert("tm.insertDB",data1);
//		형식 : sql.insert("Mapper파일의 namespace.insert id의 형식으로 쓴다.",DB에다 저장할 변수 이름);
	}
}
