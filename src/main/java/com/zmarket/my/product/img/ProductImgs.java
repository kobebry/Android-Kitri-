package com.zmarket.my.product.img;

import java.util.List;

public class ProductImgs {
	private List<ProductImg> piList;

	@Override
	public String toString() {
		return "ProductImgs []";
	}

	public ProductImgs(List<ProductImg> piList) {
		super();
		this.piList = piList;
	}

	public ProductImgs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ProductImg> getPiList() {
		return piList;
	}

	public void setPiList(List<ProductImg> piList) {
		this.piList = piList;
	}
	
	
}
