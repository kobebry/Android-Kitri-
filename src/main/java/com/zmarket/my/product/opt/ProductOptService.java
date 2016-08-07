package com.zmarket.my.product.opt;

import java.util.ArrayList;

public interface ProductOptService {
	ProductOpt getProductOpt(int num);
	ArrayList<ProductOpt> getAllProductOpts(int prod_num);
	void setProductOpt(ProductOpt po);
	void editProductOpt(ProductOpt po);
	void deleteProductOpt(int num);
	ProductOpt getProductOptByProdNumAndOption(ProductOpt po);
	void decreaseAmount(int num, int amount);
}
