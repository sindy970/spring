package com.icia.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/boardwrite")
	public String boardwrite() {
		System.out.println("boardwrite페이지로 이동");
		return "boardwriteInsert";
	}
	
	@RequestMapping(value="/boardwriteInsert")
	public ModelAndView boardwriterIndert(@ModelAttribute BoardDTO bdto) {
		mav = bs.boardwriteInsert(bdto);
		return mav;
	}
	
	@RequestMapping(value = "/boardlist")
	public ModelAndView boardList(@ModelAttribute BoardDTO bdto) {
		mav = bs.boardList(bdto);
		return mav;
	}

}
