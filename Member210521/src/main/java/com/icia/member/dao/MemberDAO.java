package com.icia.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	private ModelAndView mav;
	
	public void memberjoinInsert(MemberDTO dto) {
		sql.insert("member.memberjoininsertDB", dto);
	}

	public List<MemberDTO> memberlist() {
		return sql.selectList("member.memberlistDB");
	}

}
