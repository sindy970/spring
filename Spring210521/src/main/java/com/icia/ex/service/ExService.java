package com.icia.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.ex.dao.ExDAO;
import com.icia.ex.dto.ExDTO;

@Service
public class ExService {

	@Autowired
	private ExDAO edao;
	
	private ModelAndView mav;
	
//	매개변수를 각각 전달하는 방법
	public void insert1(String col1, String col2, String col3) {

		
	}

//	dto객체에 담아서 전달하는 방법
	public void insert2(ExDTO dto) {
		edao.insert(dto);
	}

//	SELECT로 DB를 불오기 위한 메소드
	public ModelAndView selectDB() {
		mav = new ModelAndView();
//		테이블의 컬럼이 3개 존재함으로 3개가 하나의 데이터 덩어리로써 묶어서 출력해줘야 한다.
//		전체 데이터를 조회할때 List객체를 사용하며, List에 저장되는 타입은 DTO타입을 사용한다.
		List<ExDTO> dbList = edao.selectDB();
		
		System.out.println("ExService.selectDB() : ");
		for(int i = 0; i<dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		
//		조회결과를 select.jsp로 가지고 가지
		mav.addObject("dbList", dbList);
		mav.setViewName("select");
		
		return mav;
		
	}

}
