package com.zmarket.my.order;

import java.util.ArrayList;

public class BasketBundle {
	private ArrayList<Basket> basketList;

	@Override
	public String toString() {
		return "BasketBundle [basketList=" + basketList + "]";
	}

	public BasketBundle(ArrayList<Basket> basketList) {
		super();
		this.basketList = basketList;
	}

	public BasketBundle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Basket> getBasketList() {
		return basketList;
	}

	public void setBasketList(ArrayList<Basket> basketList) {
		this.basketList = basketList;
	}
}
