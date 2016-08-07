package com.zmarket.my.order;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void addOrder(Order o) {
		// 주문등록
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		orderMapper.insert(o);
	}

	@Override
	public void deleteOrder(int num) {
		// 주문삭제
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		orderMapper.delete(num);
	}

	@Override
	public void modifyOrder(Order o) {
		// 주문정보 수정 -> 조건 : 배송시작 전
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		orderMapper.update(o);
	}

	@Override
	public List<Orders> findListByCustomer_num(int customer_num) {
		// 주문목록 가져오기
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		return orderMapper.findlistbycustomer(customer_num);
	}

	@Override
	public void addBasket(Basket b) {
		// 장바구니에 상품 등록
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		orderMapper.insert_basket(b);
	}

	@Override
	public List<Basket> findBasketByCustomer_num(int customer_num) {
		// 장바구니 목록 가져오기
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		return orderMapper.findbasketbycustomer(customer_num);
	}

	@Override
	public List<Baskets> findBasketsByCustomer_num(int customer_num) {
		// 장바구니 목록 가져오기
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		return orderMapper.findbasketsbycustomer(customer_num);
	}

	@Override
	public List<Orders> findOrderList(int customer_num) {
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		return orderMapper.findorderlist(customer_num);
	}

	@Override
	public Basket getBasket(int num) {
		return sqlSession.getMapper(OrderMapper.class).selectBasket(num);
	}

}
