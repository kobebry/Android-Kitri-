package com.zmarket.my.login;

public interface LoginService {
	void joinZmarket(Member m);
	void joinZmarketSeller(Seller s);
	int select(Member m);
	void modifyUserInfo(Member m);
	void dropUserInfo(int num);
	int dupUserCheck(String id);
	int loginCheck(Member m);
	Member getUserInfo(int num);
	int getUserPw(int num);
	void modifyUserPw(Member m);
}
