package com.zmarket.my.product.img;

import java.util.ArrayList;

public interface ProductImgMapper {
	ProductImg select(int num);
	ArrayList<ProductImg> selectAll(int prod_num);
	void insert(ProductImg pi);
	void update(ProductImg pi);
	void delete(int num);
}
