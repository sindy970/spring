package com.icia.board2.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//파일 첨부 글쓰기 주소 처리
	@RequestMapping(value="/boardwritefile")
	public ModelAndView boardWriteFile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		mav = bs.boardWriteFile(board);
		return mav;
	}
	
	//글목록 관련 주소 처리
		@RequestMapping(value="/boardlist")
		public ModelAndView boardList() {
			mav = bs.boardList();
			return mav;
		}
		
		//조회 관련 주소 처리
		@RequestMapping(value="/boardview")
		public ModelAndView boardView(@RequestParam("bnumber") int bnumber) {
			mav = bs.boardView(bnumber);
			return mav;
		}
		
		//글수정페이지 주소 처리
		@RequestMapping(value="/boardupdate")
		public ModelAndView boardUpdate(@RequestParam("bnumber") int bnumber) {
			mav = bs.boardUpdate(bnumber);
			System.out.println("update 페이지");
			return mav;
		}
		
		//글수정 데이터 처리 과정 주소 처리
		@RequestMapping(value = "/updateprocess")
		public ModelAndView updatdProcess(@ModelAttribute BoardDTO board) {
			mav = bs.updateProcess(board);
			return mav;
		}
		
		//글삭제 주소 처리
		@RequestMapping(value="/boarddelete")
		public ModelAndView boardDelete(@RequestParam("bnumber") int bnumber) {
			mav = bs.boardDelete(bnumber);
			return mav;
		}
		
		
}
