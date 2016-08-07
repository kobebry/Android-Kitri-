package com.zmarket.my.product.opt;

import java.util.List;

public class ProductOpts {
	private List<ProductOpt> poList;

	@Override
	public String toString() {
		return "ProductOpts [poList=" + poList + "]";
	}

	public ProductOpts(List<ProductOpt> poList) {
		super();
		this.poList = poList;
	}

	public ProductOpts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<ProductOpt> getPoList() {
		return poList;
	}

	public void setPoList(List<ProductOpt> poList) {
		this.poList = poList;
	}
	
	
}
