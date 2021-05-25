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

	public String memberLogin(MemberDTO member) {
		return sql.selectOne("member.memberlogin", member);
	}

	public MemberDTO update(String loginId) {
		return sql.selectOne("member.memberupdate", loginId);
	}

	public int updateProces(MemberDTO member) {
		return sql.update("member.updateprocess", member);
		//update라는 함수도 리턴타입이 int타입니다.
	}

	public void memberDelete(String mid) {
		sql.delete("member.memberdelete", mid);
		//delete라는 함수도 리턴값이 int타입이다.
	}

}
