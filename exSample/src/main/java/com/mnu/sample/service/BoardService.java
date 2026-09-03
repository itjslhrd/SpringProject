package com.mnu.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnu.sample.domain.BoardDTO;
import com.mnu.sample.domain.PageSearchDTO;
import com.mnu.sample.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	//1. 전체 글수 카운트
	public int boardCount() {
		//int row = boardMapper.boardCount();
		//row++;
		//return row;
		return boardMapper.boardCount();
	}
	
	//2. 검색조건에 해당하는 글수
	public int boardCountSearch(String search, String key) {
		return boardMapper.boardCountSearch(search, key);
	}
	
	//3. 전체목록 리스트
	public List<BoardDTO> boardList(){
		return boardMapper.boardList();
	}
	
	//3-1. 전체목록 리스트(페이지 인덱싱)
	public List<BoardDTO> boardListPage(PageSearchDTO pageSearchDTO){
		return boardMapper.boardListPage(pageSearchDTO);
	}
	
	//4. 검색조건에 맞는 글 리스트
	public List<BoardDTO> boardListSearch(String search, String key){
		return boardMapper.boardListSearch(search, key);
	}

	//4-1. 검색조건 + 페이지 인덱싱 리스트
	public List<BoardDTO> boardListSearchPage(PageSearchDTO pageSearchDTO){
		return boardMapper.boardListSearchPage(pageSearchDTO);
	}

	//5. 글 등록 
	public int boardWrite(BoardDTO boardDTO) {
		return boardMapper.boardWrite(boardDTO);
	}
	//6. 특정글 검색(view, 수정)
	
	//7. 수정처리
	
	//8. 삭제처리

}
