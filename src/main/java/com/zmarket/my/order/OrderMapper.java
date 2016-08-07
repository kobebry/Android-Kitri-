package com.zmarket.my.order;

import java.util.List;

public interface OrderMapper {
	void insert(Order o); //주문추가
	void insert_basket(Basket b); //장바구니에 추가
	void delete(int num); //주문삭제 -> 주문 완료로 변경
	void update(Order o); //주문내용 변경 -> 배송전까지만 적용
	List<Orders> findorderlist(int customer_num);
	List<Orders> findlistbycustomer(int customer_num); //주문목록 가져오기
	List<Basket> findbasketbycustomer(int customer_num); //장바구니 목록 가져오기
	List<Baskets> findbasketsbycustomer(int customer_num); //장바구니 목록 가져오기
	Basket selectBasket(int num);
}
