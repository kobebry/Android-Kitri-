package com.zmarket.my.login;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void joinZmarket(Member m) {
		// Insert members Table
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		loginMapper.insert(m);
	}
	
	@Override
	public void joinZmarketSeller(Seller s) {
		// insert Seller Table
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		loginMapper.insert_seller(s);
	}

	@Override
	public int select(Member m) {
		// TODO Auto-generated method stub
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		return loginMapper.select(m);
	}

	@Override
	public void modifyUserInfo(Member m) {
		// TODO Auto-generated method stub
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		loginMapper.update(m);
	}

	@Override
	public void dropUserInfo(int num) {
		// TODO Auto-generated method stub
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		loginMapper.delete(num);
	}

	@Override
	public int dupUserCheck(String id) {
		// ID 중복검사
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		int dupChk = loginMapper.duplicate(id);
		return dupChk;
	}

	@Override
	public int loginCheck(Member m) {
		// TODO Auto-generated method stub
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		return loginMapper.login(m);
	}

	@Override
	public Member getUserInfo(int num) {
		// 로그인 유저 정보
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		return loginMapper.getuserinfo(num);
	}

	@Override
	public int getUserPw(int num) {
		// 마이페이지 비밀번호 체크
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		return loginMapper.getuserpw(num);
	}

	@Override
	public void modifyUserPw(Member m) {
		// 마이페이지 비밀번호 변경
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		loginMapper.updatepw(m);
	}
}
