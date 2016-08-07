package com.zmarket.my.category;

import java.util.ArrayList;

public interface CategoryMapper {
	Category select(int num);
	ArrayList<Category> selectAll();
	ArrayList<Category> selectByParent(int parentNum);
	void insert(Category c);
	void update(Category c);
	void delete(int num);
}
