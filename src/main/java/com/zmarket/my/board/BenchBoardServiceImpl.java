package com.zmarket.my.board;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;


@Component("BenchBoardService")
public class BenchBoardServiceImpl implements BenchBoardService {

	@Resource(name="sqlSession")
	private SqlSession sqlSession;


	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	@Override
	public void WriteBenchBoard(BenchBoard b) {
		BenchBoardMapper benchboardmapper = sqlSession.getMapper(BenchBoardMapper.class);
		benchboardmapper.insert(b);
	}

	@Override
	public List<BenchBoard> getBenchBoardAll() {
		BenchBoardMapper benchboardmapper = sqlSession.getMapper(BenchBoardMapper.class);
		return benchboardmapper.selectAll();
	}

	@Override
	public List<BenchBoard> getBenchBoardByProdNum(int prod_num) {
		BenchBoardMapper benchboardmapper = sqlSession.getMapper(BenchBoardMapper.class);
		return benchboardmapper.selectByProdNum(prod_num);
	}

	@Override
	public void editBenchBoard(BenchBoard b) {
		BenchBoardMapper benchboardmapper = sqlSession.getMapper(BenchBoardMapper.class);
		benchboardmapper.update(b);
	}

	@Override
	public void delBenchBoard(int num) {
		BenchBoardMapper benchboardmapper = sqlSession.getMapper(BenchBoardMapper.class);
		benchboardmapper.delect(num);
	}

	@Override
	public BenchBoard getBenchBoard(int num) {
		BenchBoardMapper benchboardmapper = sqlSession.getMapper(BenchBoardMapper.class);
		return benchboardmapper.select(num);
	}

}
