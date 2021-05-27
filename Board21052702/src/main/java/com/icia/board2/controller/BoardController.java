package com.icia.board2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board2.dto.BoardDTO;
import com.icia.board2.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	private ModelAndView mav;
	
	@RequestMapping(value="/writepage")
	public String writepage() {
		return "boardwrite";
	}
	
	@RequestMapping(value="/boardwrite")
	public ModelAndView boardWrite(@ModelAttribute BoardDTO board) {
		mav = bs.boardWrite(board);
		return mav;
	}
}
