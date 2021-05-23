package com.icia.study.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void insertDB(String param1) {
		sql.insert("study.insertDB",param1);
	}

	public List<String> selectDB() {
// 넘겨주는 데이터가 없기 때문에 mapper호출하는 부분만 작성함.
//		mapper를 통해 조회한 데이터를 list에 담아서 studyservice로 리턴해준다.
		return sql.selectList("study.selectDB");
	}

}
