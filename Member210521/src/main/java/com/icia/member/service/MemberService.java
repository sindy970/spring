package com.icia.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.member.dao.MemberDAO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO mdao;
	
	private ModelAndView mav;
	
	public void memberjoinInsert(MemberDTO dto) {
		mdao.memberjoinInsert(dto);
	}

	public ModelAndView memberlist() {
		mav = new ModelAndView();
		List<MemberDTO> mdtoList = mdao.memberlist();
		
		mav.setViewName("memberlist");
		mav.addObject("mdtoList", mdtoList);
		
		return mav;
	}

}
