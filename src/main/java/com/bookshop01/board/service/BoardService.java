package com.bookshop01.board.service;

import java.util.List;

import com.bookshop01.board.vo.ArticleVO;

public interface BoardService {

	List<ArticleVO> listArticles() throws Exception;

}
