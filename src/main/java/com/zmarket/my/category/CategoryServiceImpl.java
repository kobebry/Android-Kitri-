package com.zmarket.my.category;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Category getCategory(int num) {
		return sqlSession.getMapper(CategoryMapper.class).select(num);
	}

	@Override
	public ArrayList<Category> getAllCategory() {
		return sqlSession.getMapper(CategoryMapper.class).selectAll();
	}

	@Override
	public ArrayList<Category> getSubCategories(int num) {
		return sqlSession.getMapper(CategoryMapper.class).selectByParent(num);
	}

	@Override
	public void setCategory(Category c) {
		sqlSession.getMapper(CategoryMapper.class).insert(c);
	}

	@Override
	public void editCategory(Category c) {
		sqlSession.getMapper(CategoryMapper.class).update(c);
	}

	@Override
	public void deleteCategory(int num) {
		sqlSession.getMapper(CategoryMapper.class).delete(num);
	}

}
