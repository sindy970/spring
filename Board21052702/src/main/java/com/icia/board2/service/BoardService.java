package com.icia.board2.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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

	public ModelAndView boardWriteFile(BoardDTO board) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		
		//dto에 담긴 파일을 가져 온다.
		MultipartFile bfile = board.getBfile();
		
		//파일이름을 가져온다.(파일이름을 db에 저장하기 위해 사용됨)
		String bfilename = bfile.getOriginalFilename();
		
		//파일명 중복을 피하기 위해 파일이름앞에 현재 시간을 붙인다.
		bfilename = System.currentTimeMillis()+"-"+bfilename;
		System.out.println("boardWriteFile메소드 " + bfilename);
		
		//어느 특정 장소에 파일 저장하기
		String savePath = "D:\\spring\\Board21052702\\src\\main\\webapp\\resources\\upload\\"+bfilename;
		
		//bfile이 비어있지 않다면 savePath에 저장하겠다.
		if(!bfile.isEmpty()) {
			//예외처리를 해줘야 한다. (throws로)
			bfile.transferTo(new File(savePath));
		} 
		//여기까지의 내용은 파일을 저장하는 과정이다.
		
		//파일 이름을 dto에 담는 것
		board.setBfilename(bfilename);
		
		//insert쿼리를 실행하기 위해서 DB에 담는 과정
		bdao.boardWriteFile(board);
		
		mav.setViewName("redirect:/boardlist");
		return mav;
	}
	
	public ModelAndView boardList() {
		/*
		 * 목록을 화면에 출력하기만 하면 되기 때문에 매개변수로 값을 가져오거나 받아올 것이 없다.
		 * 따라서 궅이 매개변수를 만들 필요가 없다.
		 */
		mav = new ModelAndView();
		
		List<BoardDTO> boardList = bdao.boardList();
		
		mav.addObject("boardList", boardList);
		mav.setViewName("boardlist");
		return mav;
	}

	public ModelAndView boardView(int bnumber) {
		mav = new ModelAndView();
		/* 
		 * 해야 할 일
		 * 1. 해당글의 조회수 값 증가 (update쿼리)
		 * 2. 해당 글의 내용가져오기(select 쿼리)
		 */
		
		bdao.boardHits(bnumber);
		
		BoardDTO board = bdao.boardView(bnumber);
		mav.addObject("board", board);
		mav.setViewName("boardview");
		
		return mav;
	}

	public ModelAndView boardUpdate(int bnumber) {
		mav = new ModelAndView();
		BoardDTO board = bdao.boardView(bnumber);
		System.out.println("update처리 페이지");
		mav.addObject("boardUpdate", board);
		mav.setViewName("boardupdate");
		return null;
	}

	public ModelAndView updateProcess(BoardDTO board) {
		mav = new ModelAndView();
		int updateResult = bdao.updateProcess(board);
		
		if(updateResult > 0) {
			//1. 목록출력
//			mav.setViewName("boardlist"); //boardlist.jsp로 목적지 지정을 한 것이다.
			mav.setViewName("redirect:/boardlist"); //데이터를 같이 보내기 위애서 redirect를 사용하여 controller의 주소값으로 목적지를 지정해 준다.
			//2. 해당 글의 상세화면 출력
			mav.setViewName("redirect:/boardview?bnumber="+board.getBnumber());
		} else {
			
		}
		return mav;
	}

	public ModelAndView boardDelete(int bnumber) {
		mav = new ModelAndView();
		int deleteResult = bdao.boardDelete(bnumber);
		
		if(deleteResult > 0) {
			mav.setViewName("redirect:/boardlist");
		}
		return mav;
	}

	
}
