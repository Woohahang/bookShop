package com.bookshop01.mypage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshop01.member.vo.MemberVO;
import com.bookshop01.mypage.dao.MyPageDAO;
import com.bookshop01.mypage.vo.MyPageVO;
import com.bookshop01.order.vo.OrderVO;

@Service("myPageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MyPageServiceImpl implements MyPageService {
	@Autowired
	private MyPageDAO myPageDAO;

	public List<OrderVO> listMyOrderGoods(String member_id) throws Exception {
		return myPageDAO.selectMyOrderGoodsList(member_id);
	}

	public List findMyOrderInfo(String order_id) throws Exception {
		return myPageDAO.selectMyOrderInfo(order_id);
	}

	public List<OrderVO> listMyOrderHistory(Map dateMap) throws Exception {
		return myPageDAO.selectMyOrderHistoryList(dateMap);
	}

	public MemberVO modifyMyInfo(Map memberMap) throws Exception {
		String member_id = (String) memberMap.get("member_id");
		myPageDAO.updateMyInfo(memberMap);
		return myPageDAO.selectMyDetailInfo(member_id);
	}

	public void cancelOrder(String order_id) throws Exception {
		myPageDAO.updateMyOrderCancel(order_id);
	}

	public MemberVO myDetailInfo(String member_id) throws Exception {
		return myPageDAO.selectMyDetailInfo(member_id);
	}

	// 회원 탈퇴 // 로그인 되어 있는 id를 가지고 와 sql 문에 한 행 삭제
	@Override
	public void myPageDelete(String _id) throws Exception {
		myPageDAO.deleteMypage(_id);
	}

}
