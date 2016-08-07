package com.zmarket.my.product.img;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("productImgService")
public class ProductImgServiceImpl implements ProductImgService {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public ProductImg getProductImg(int num) {
		return sqlSession.getMapper(ProductImgMapper.class).select(num);
	}

	@Override
	public ArrayList<ProductImg> getAllProductImgs(int prod_num) {
		return sqlSession.getMapper(ProductImgMapper.class).selectAll(prod_num);
	}

	@Override
	public void setProductImg(ProductImg pi) {
		sqlSession.getMapper(ProductImgMapper.class).insert(pi);
	}

	@Override
	public void editProductImg(ProductImg pi) {
		sqlSession.getMapper(ProductImgMapper.class).update(pi);
	}

	@Override
	public void deleteProductImg(int num) {
		sqlSession.getMapper(ProductImgMapper.class).delete(num);
	}

}
