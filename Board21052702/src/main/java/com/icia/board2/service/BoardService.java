package com.icia.board2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board2.dao.BoardDAO;
import com.icia.board2.dto.BoardDTO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO bdao;
	
	private ModelAndView mav;

	public ModelAndView boardWrite(BoardDTO board) {
		mav = new ModelAndView();
		
		int writeResult = bdao.boardWrite(board);
		/* 
		 * 글쓰기 성공 : 목록출력(redirect로 boardlist의 주소를 요청해야 한다.)
		 * 글쓰기 실패 : boardwrite.jsp를 띄움 
		 */ 
		
		if(writeResult >0) {
			mav.setViewName("redirect:/boardlist");
		} else {
			mav.setViewName("boardwrite");
		}
		return mav;
	}
	
}
