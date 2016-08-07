package com.zmarket.my.product.opt;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductOptMapper {
	ProductOpt select(int num);
	ArrayList<ProductOpt> selectAll(int prod_num);
	void insert(ProductOpt po);
	void update(ProductOpt po);
	void delete(int num);
	ProductOpt selectByProdNumAndOption(ProductOpt po);
	void updateAmountForDecrease(HashMap map);
}
