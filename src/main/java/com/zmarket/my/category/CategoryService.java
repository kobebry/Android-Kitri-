package com.zmarket.my.category;

import java.util.ArrayList;

public interface CategoryService {
	Category getCategory(int num);
	ArrayList<Category> getAllCategory();
	ArrayList<Category> getSubCategories(int num);
	void setCategory(Category c);
	void editCategory(Category c);
	void deleteCategory(int num);
}
