package com.bookshop01.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop01.board.dao.BoardDAO;
import com.bookshop01.board.vo.ArticleVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<ArticleVO> listArticles() throws Exception {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}



	// @Autowired
//	
//
//	// 다중 파일 보이기
//	@Override
//	public Map viewArticle(int articleNO) throws Exception {
//		Map articleMap = new HashMap();
//		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
//		List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
//		articleMap.put("article", articleVO);
//		articleMap.put("imageFileList", imageFileList);
//		return articleMap;
//	}
//
//	@Override
//	public int addNewArticle(Map articleMap) throws Exception {
//		int articleNO = boardDAO.insertNewArticle(articleMap);
//		articleMap.put("articleNO", articleNO);
//		boardDAO.insertNewImage(articleMap);
//		return articleNO;
//	}
//
//	// 삭제
//	@Override
//	public void removeArticle(int articleNO) throws Exception {
//		boardDAO.deleteArticle(articleNO);
//	}
//
//	@Override
//	public void modArticle(Map articleMap) throws Exception {
//		boardDAO.updateArticle(articleMap);
//	}
}
