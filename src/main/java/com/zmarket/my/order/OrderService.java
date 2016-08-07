package com.zmarket.my.order;

import java.util.List;

public interface OrderService {
	void addOrder(Order o);
	void addBasket(Basket b);
	void deleteOrder(int num);
	void modifyOrder(Order o);
	List<Orders> findOrderList(int customer_num);
	List<Orders> findListByCustomer_num(int customer_num);
	List<Basket> findBasketByCustomer_num(int customer_num);
	List<Baskets> findBasketsByCustomer_num(int customer_num);
	Basket getBasket(int num);
}
