package com.bookshop01.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.bookshop01.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	@Qualifier("sqlSession_ID")
	private SqlSession sqlSession_variable;

	@Override
	public MemberVO login(Map loginMap) throws DataAccessException {
		MemberVO member = (MemberVO) sqlSession_variable.selectOne("mapper.member.login", loginMap);
		return member;
	}

	@Override
	public void insertNewMember(MemberVO memberVO) throws DataAccessException {
		sqlSession_variable.insert("mapper.member.insertNewMember", memberVO);
	}

	@Override
	public String selectOverlappedID(String id) throws DataAccessException {
		String result = sqlSession_variable.selectOne("mapper.member.selectOverlappedID", id);
		return result;
	}

}
