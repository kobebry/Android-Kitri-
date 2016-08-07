package com.zmarket.my.product;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("productService")
public class ProductServiceImpl implements ProductService {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Product getProduct(int num) {
		return sqlSession.getMapper(ProductMapper.class).select(num);
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		return sqlSession.getMapper(ProductMapper.class).selectAll();
	}

	@Override
	public ArrayList<Product> getProductsBySeller(int sellerNum) {
		return sqlSession.getMapper(ProductMapper.class).selectBySeller(sellerNum);
	}

	@Override
	public ArrayList<Products> getProductsByCategory(int categoryNum) {
		return sqlSession.getMapper(ProductMapper.class).selectByCategory(categoryNum);
	}

	@Override
	public ArrayList<Products> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ProductMapper.class).selectByName("%"+name+"%");
	}
	
	@Override
	public void setProduct(Product p) {
		sqlSession.getMapper(ProductMapper.class).insert(p);
	}

	@Override
	public void editProduct(Product p) {
		sqlSession.getMapper(ProductMapper.class).update(p);
	}

	@Override
	public void deleteProduct(int num) {
		sqlSession.getMapper(ProductMapper.class).delete(num);
	}

	@Override
	public int getProductNum() {
		return sqlSession.getMapper(ProductMapper.class).getSeqNum();
	}

	@Override
	public Products getProducts(int num) {
		return sqlSession.getMapper(ProductMapper.class).selectProducts(num);
	}

	@Override
	public List<Products> getProductsByDate() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(ProductMapper.class).selectByDate();
	}
}
