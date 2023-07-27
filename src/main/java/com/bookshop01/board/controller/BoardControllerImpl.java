package com.bookshop01.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.board.service.BoardService;
import com.bookshop01.board.vo.ArticleVO;

@Controller
@RequestMapping("/board")
public class BoardControllerImpl implements BoardController {

	@Autowired
	BoardService boardService;

	@Override
	@RequestMapping("/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		List<ArticleVO> articlesList = boardService.listArticles();
		mav.addObject("articlesList", articlesList);

		return mav;
	}

	
	@RequestMapping("/addArticle.do")
	public ModelAndView addArticle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		
		
		return mav;
	}

}