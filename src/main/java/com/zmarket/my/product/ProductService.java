package com.zmarket.my.product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
	int getProductNum();
	Product getProduct(int num);
	ArrayList<Product> getAllProducts();
	ArrayList<Product> getProductsBySeller(int sellerNum);
	ArrayList<Products> getProductsByCategory(int categoryNum);
	ArrayList<Products> getProductsByName(String name);
	void setProduct(Product p);
	void editProduct(Product p);
	void deleteProduct(int num);
	Products getProducts(int num);
	List<Products> getProductsByDate();
}
