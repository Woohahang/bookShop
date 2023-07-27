package com.bookshop01.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookshop01.member.vo.MemberVO;

@Controller("ddd")
@RequestMapping(value = "/test")
public class test {

	@Autowired
	MemberVO memberVO;

	@RequestMapping(value = "/tt.do", method = RequestMethod.GET)
	public void testtest(HttpServletRequest request) throws Exception {

		// 여기에 오는 버튼은 삭제한 상태다.

		HttpSession session = request.getSession();
		session = request.getSession();
		// 세션에 둥둥 떠다니는 memberInfo 라는 문자열 안에 담겨있는 멤버 vo 객체를 잡아서 넣어줌
		memberVO = (MemberVO) session.getAttribute("memberInfo");

		System.out.println((String) request.getAttribute("viewName"));

		// 그래서 이제 null 이 안 뜬다.
		System.out.println(memberVO.getMember_id());

	}

}