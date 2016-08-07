package com.zmarket.my.product;

import java.util.ArrayList;
import java.util.List;

public interface ProductMapper {
	int getSeqNum();
	Product select(int num);
	ArrayList<Product> selectAll();
	ArrayList<Product> selectBySeller(int seller_num);
	ArrayList<Products> selectByCategory(int category_num);
	ArrayList<Products> selectByName(String name);
	void insert(Product p);
	void update(Product p);
	void delete(int num);
	Products selectProducts(int num);
	List<Products> selectByDate();
}
