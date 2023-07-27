package com.bookshop01.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.board.vo.ArticleVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ArticleVO> selectAllArticles() throws DataAccessException {
		List<ArticleVO> articlesList = sqlSession.selectList("mapper.board.selectAllArticles");
		return articlesList;
	}
	
	
	
	
	
//	
//	// 오토와이드 애는 뭐냐? xml 파일에 있는 똑같은 타입! 타입!! 타입과 같은 애랑 매칭 시켜줌 // 근데 막상 보면? SqlSessionTemplate 클래스 이름이 이거임 뭐지?? 할 수 도 있는데 얘의 클래스랑 같이 걸려있는 애가 SqlSession 임마임!!!
//	@Autowired
//	@Qualifier("sqlSession1") // 그래서 이걸 걸어봤음 @Qualifier !! 이거 뭐냐?? 오토 와이드로 같은 타입을 찾으라 했는데 두개 이상 같은 bean 이 있는거임 그럴 때! 에러가 뜨는데 더 명확히 구분해주는게 바로 @Qualifier 임마를 이용해서 id까지 찾아라! 하는거임
//	private SqlSession sqlSessionTest; // sqlSessionTest 얘는 뭐냐? 걍 변수명임 내가 맘대로 쓴거 특별한거 아님 쓰레기 쓰레기
//
//	@Override
//	public List selectAllArticlesList() throws DataAccessException {
//		List<ArticleVO> articlesList = sqlSessionTest.selectList("mapper.board.selectAllArticlesList");
//		return articlesList;
//	}
//
//	@Override
//	public int insertNewArticle(Map articleMap) throws DataAccessException {
//		int articleNO = selectNewArticleNO();
//		articleMap.put("articleNO", articleNO);
//		sqlSessionTest.insert("mapper.board.insertNewArticle", articleMap);
//		return articleNO;
//	}
//
//	private int selectNewArticleNO() throws DataAccessException {
//		return sqlSessionTest.selectOne("mapper.board.selectNewArticleNO");
//	}
//
//	@Override
//	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
//		return sqlSessionTest.selectOne("mapper.board.selectArticle", articleNO);
//	}
//
//	@Override
//	public void updateArticle(Map articleMap) throws DataAccessException {
//		sqlSessionTest.update("mapper.board.updateArticle", articleMap);
//	}
//
//	@Override
//	public void deleteArticle(int articleNO) throws DataAccessException {
//		sqlSessionTest.delete("mapper.board.deleteArticle", articleNO);
//
//	}
//
//	@Override
//	public void insertNewImage(Map articleMap) throws DataAccessException {
//		List<ImageVO> imageFileList = (ArrayList) articleMap.get("imageFileList");
//		int articleNO = (Integer) articleMap.get("articleNO");
//		int imageFileNO = selectNewImageFileNO();
//		for (ImageVO imageVO : imageFileList) {
//			imageVO.setImageFileNO(++imageFileNO);
//			imageVO.setArticleNO(articleNO);
//		}
//		sqlSessionTest.insert("mapper.board.insertNewImage", imageFileList);
//	}
//
//	private int selectNewImageFileNO() throws DataAccessException {
//		return sqlSessionTest.selectOne("mapper.board.selectNewImageFileNO");
//	}
//
//	
//	
//	
//	@Override
//	public List selectImageFileList(int articleNO) throws DataAccessException {
//		List<ImageVO> imageFileList = null;
//		imageFileList = sqlSessionTest.selectList("mapper.board.selectImageFileList",articleNO);
//		return imageFileList;
//	}
}
