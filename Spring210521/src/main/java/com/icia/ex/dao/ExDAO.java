package com.icia.ex.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.ex.dto.ExDTO;

@Repository
public class ExDAO {
// dao(Data Access Object)
// dto(Data Transfer Object) -> 데이터 전달이 목적이다.
	@Autowired
	private SqlSessionTemplate sql;
	
	public void insert(ExDTO dto) {
		sql.insert("ex.insertDB", dto);
		
	}

	public List<ExDTO> selectDB() {
		return sql.selectList("ex.selectDB");
	}

}
