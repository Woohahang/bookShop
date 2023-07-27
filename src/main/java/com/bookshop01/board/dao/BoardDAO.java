package com.bookshop01.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.bookshop01.board.vo.ArticleVO;

public interface BoardDAO {

	List<ArticleVO> selectAllArticles() throws DataAccessException;

}
