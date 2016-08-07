package com.zmarket.my.product.opt;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("productOptService")
public class ProductOptServiceImpl implements ProductOptService {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public ProductOpt getProductOpt(int num) {
		return sqlSession.getMapper(ProductOptMapper.class).select(num);
	}

	@Override
	public ArrayList<ProductOpt> getAllProductOpts(int prod_num) {
		return sqlSession.getMapper(ProductOptMapper.class).selectAll(prod_num);
	}

	@Override
	public void setProductOpt(ProductOpt po) {
		sqlSession.getMapper(ProductOptMapper.class).insert(po);
	}

	@Override
	public void editProductOpt(ProductOpt po) {
		sqlSession.getMapper(ProductOptMapper.class).update(po);
	}

	@Override
	public void deleteProductOpt(int num) {
		sqlSession.getMapper(ProductOptMapper.class).delete(num);
	}

	@Override
	public ProductOpt getProductOptByProdNumAndOption(ProductOpt po) {
		return sqlSession.getMapper(ProductOptMapper.class).selectByProdNumAndOption(po);
	}

	@Override
	public void decreaseAmount(int num, int amount) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		map.put("amount", amount);
		sqlSession.getMapper(ProductOptMapper.class).updateAmountForDecrease(map);
	}

	

}
