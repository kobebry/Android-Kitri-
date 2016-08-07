package com.zmarket.my.product.img;

import java.util.ArrayList;

public interface ProductImgService {
	ProductImg getProductImg(int num);
	ArrayList<ProductImg> getAllProductImgs(int prod_num);
	void setProductImg(ProductImg pi);
	void editProductImg(ProductImg pi);
	void deleteProductImg(int num);
}
