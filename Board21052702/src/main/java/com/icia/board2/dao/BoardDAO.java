package com.icia.board2.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board2.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int boardWrite(BoardDTO board) {
		return sql.insert("bm.boardwrite", board);
	}

	public void boardWriteFile(BoardDTO board) {
		sql.insert("bm.boardwritefile", board);
	}
	
	public List<BoardDTO> boardList() {
		return sql.selectList("bm.boardlist");
	}

	public void boardHits(int bnumber) {
		sql.update("bm.boardhits", bnumber);
	}

	public BoardDTO boardView(int bnumber) {
		return sql.selectOne("bm.boardview", bnumber);
	}

	public int updateProcess(BoardDTO board) {
		return sql.update("bm.boardupdate", board);
	}

	public int boardDelete(int bnumber) {
		return sql.delete("bm.boarddelete", bnumber);
	}



}
