package com.icia.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.study.dao.StudyDAO;

@Service
public class StudyService {
	
	@Autowired
	private StudyDAO sdao;
	
	private ModelAndView mav;
	
	public void insertDB(String param1) {
		sdao.insertDB(param1);
	}

//	테이블에 들어있는 데이터를 조회할 때는 ArrayLIST에 형태로 가져오는 것이 낫다. 왜냐하면 데이터가 하나가 아니기 때문이다.
	public ModelAndView selectDB() {
		mav = new ModelAndView();
//		DB에서 조회한 내용을 arraylist에 담음
//		우변 : db에서 조회한 결과를 list에 담아옴
//		좌변 : 담아온 내용을 dbList변수에 저장한다.
		List<String> dbList = sdao.selectDB();
//		dbList에 담긴 값을 가지고 select.jsp로 이동해야 함
//		어떤 데이터를 어떤 페이지로 가지고 가기 위해서는 mav객체를 활용해야 한다.

//		dbList변수 값 확인
		System.out.println("dbList확인");
		for(int i=0; i<dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		
		//		데이터를 담는 내용
//		(화면애 보여줄때 변수이름, db에서 가져온 값이 들어있는 변수이름)
		mav.addObject("dbList", dbList);
//		목적지를 지정하는 내용
//		(어디로갈건지를 지정하는 jsp파일이름)
		mav.setViewName("select");
//		dbList값을 -> "dbList"에 넣어서 => select.jsp로 간다.
		
//		그냥 화면으로만 갈때는 컨트롤러에서 String리턴만 하면 되지만 어떤 데이터를 가지고 갈때는 mav를 이용한다.
		return mav;
	}

}
