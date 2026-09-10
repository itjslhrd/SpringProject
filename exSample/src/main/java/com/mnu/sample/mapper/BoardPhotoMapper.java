package com.mnu.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mnu.sample.domain.BoardDTO;
import com.mnu.sample.domain.BoardPhotoDTO;
import com.mnu.sample.domain.PageSearchDTO;

@Mapper
public interface BoardPhotoMapper {
	// 최근 글 n개 검색
	public List<BoardPhotoDTO> boardTopList(int num);
	
	//1. 전체 글수 카운트(get, post 겸용)
	public int boardCount(String search, String key);
	
	//2. 전체목록 리스트(검색, 페이지처리)
	public List<BoardPhotoDTO> boardList(PageSearchDTO pageSearchDTO);

	//3. 글 등록 
	public int boardWrite(BoardPhotoDTO boardPhotoDTO);
	
	//4. 특정글 조회수 증가
	public void boardHits(int idx);//조회수 증가

	//5. 특정글 검색(view, 수정)
	public BoardPhotoDTO boardSelect(int idx);
	
	//6. 수정처리 처리
	public int boardModify(BoardPhotoDTO boardPhotoDTO);
	
	//7. 삭제처리
	public int boardDelete(BoardPhotoDTO boardPhotoDTO);
	
}
