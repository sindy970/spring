package com.icia.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO bdao;
	
	private ModelAndView mav;

	public ModelAndView boardwriteInsert(BoardDTO bdto) {
		mav = new ModelAndView();
		int writerResult = bdao.boardwriteInsert(bdto);
		
		if(writerResult >0) {
			mav.setViewName("redirect:/boardlist");
		} else {
			mav.setViewName("boardwriteInsert");
		}
		
		return mav;
	}

	public ModelAndView boardList(BoardDTO bdto) {
		mav = new ModelAndView();
		List<BoardDTO> bdtoList = bdao.boardList(bdto);
		
		mav.addObject("bdtoList", bdtoList);
		mav.setViewName("boardlist");
		
		return mav;
	}

	
	
	

}
