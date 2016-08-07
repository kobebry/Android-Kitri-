package com.zmarket.my.product;

import com.zmarket.my.order.Basket;
import com.zmarket.my.product.img.ProductImg;
import com.zmarket.my.product.opt.ProductOpt;

public class ProductBundle {
	private Product product;
	private ProductImg productImg;
	private Basket basket;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductImg getProductImg() {
		return productImg;
	}
	public void setProductImg(ProductImg productImg) {
		this.productImg = productImg;
	}
	
	
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	public ProductBundle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBundle(Product product, ProductImg productImg, Basket basket) {
		super();
		this.product = product;
		this.productImg = productImg;
		this.basket = basket;
	}
	
	
}
