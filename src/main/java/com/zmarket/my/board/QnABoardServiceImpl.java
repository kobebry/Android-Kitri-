package com.zmarket.my.board;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("QnABoardService")
public class QnABoardServiceImpl implements QnABoardService {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;


	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	
	@Override
	public QnABoard getQnABoard(int num) {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);		
		return qnaboard.select(num);
	}

	@Override
	public List getQnABoardAll() {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);
		return qnaboard.selectAll();
	}

	@Override
	public void WriteQnABoard(QnABoard q) {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);
		qnaboard.insert(q);

	}

	@Override
	public void editQnABoard(QnABoard q) {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);
		qnaboard.update(q);
	}

	@Override
	public void delQnABoard(int num) {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);
		qnaboard.delete(num);
	}


	@Override
	public void WriteRep(QnABoard q) {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);
		qnaboard.insert_rep(q);

	}
	@Override
	public List getRep(int num) {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);
		return qnaboard.select_rep(num);
	}


	@Override
	public QnABoard getRepByNum(int num) {
		QnABoardMapper qnaboard = sqlSession.getMapper(QnABoardMapper.class);

		return qnaboard.get_rep(num);
	}


}
