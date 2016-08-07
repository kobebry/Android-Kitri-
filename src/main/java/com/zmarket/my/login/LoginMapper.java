package com.zmarket.my.login;

public interface LoginMapper {
	void insert(Member m);
	void insert_seller(Seller s);
	int select(Member m);
	void update(Member m);
	void delete(int num);
	int duplicate(String id);
	int login(Member m);
	Member getuserinfo(int num);
	int getuserpw(int num);
	void updatepw(Member m);
}
