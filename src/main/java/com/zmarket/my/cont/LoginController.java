package com.zmarket.my.cont;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zmarket.my.login.LoginService;
import com.zmarket.my.login.Member;
import com.zmarket.my.login.Seller;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService service;
	
	public void setService(LoginService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/logincont/login.do")
	public ModelAndView login(Member m, HttpSession hs){ //Login 처리
		System.out.println("LoginCont -> loginCheck");
		int loginChk = service.loginCheck(m);
		ModelAndView mav = null;
		if(loginChk == 1){
			mav = new ModelAndView("redirect:/viewcont/main.do");
			int num = service.select(m);
			hs.setAttribute("num", num);
			Member member = service.getUserInfo(num);
			mav.addObject("TYPE", member.getType());
			return mav;
		}else{
			mav = new ModelAndView("/login/login");
			return mav;
		}
	}
	@RequestMapping(value="/logincont/logout.do")
	public String logout(HttpServletRequest req){
		System.out.println("LoginCont -> logOut");
		HttpSession hs = req.getSession();
		hs.invalidate();
		return "redirect:/viewcont/main.do";
	}
	@RequestMapping(value="/logincont/idcheck.do")
	public ModelAndView idCheck(@RequestParam(value="id")String id){
		System.out.println("LoginCont -> idCheck");
		int userCheck = service.dupUserCheck(id);
		ModelAndView mav = new ModelAndView("JSON/idCheckJSON");
		mav.addObject("check", userCheck);
		return mav;
	}
	@RequestMapping(value="/logincont/join.do")
	public String join(Member m){ //Join 처리
		System.out.println("LoginCont -> Join");
		System.out.println(m);
		service.joinZmarket(m);
		return "login/login";
	}
	@RequestMapping(value="/logincont/join_seller.do")
	public String join_Seller(Member m ,Seller s){ //Join_seller 처리
		System.out.println("LoginCont -> Join_Seller");
		//seller_num을 가져와야 하므로 merbers테이블에 먼저 등록하고 num값을 가져온다
		service.joinZmarket(m);
		int seller_num = service.select(m);
		s.setSeller_num(seller_num);
		service.joinZmarketSeller(s);
		return "login/login";
	}
	@RequestMapping(value="/logincont/getuserinfo.do")
	public ModelAndView getUserInfo(@RequestParam(value="num")int num){
		System.out.println("LoginCont -> getUserInfo");
		ModelAndView mav = new ModelAndView("JSON/loginUserInfoJSON");
		Member m = service.getUserInfo(num);
		mav.addObject("member", m);
		return mav;
	}
	@RequestMapping(value="/logincont/getuserpw.do")
	public ModelAndView getUserPw(@RequestParam(value="num")int num, @RequestParam(value="password")int password){
		System.out.println("LoginCont -> getUserPw");
		ModelAndView mav = new ModelAndView("JSON/pwCheckJSON");
		int get_pw = service.getUserPw(num);
		if(get_pw == password){
			mav.addObject("check", 1);
		}else{
			mav.addObject("check", 0);
		}
		return mav;
	}
	@RequestMapping(value="/logincont/modify.do")
	public String modify(Member m, HttpSession hs){
		System.out.println("LoginCont -> modify /"+hs.getAttribute("num"));
		service.modifyUserInfo(m);
		return "redirect:/viewcont/main.do";
	}
	@RequestMapping(value="/logincont/modifypw.do")
	public String modifyPw(Member m){
		System.out.println("LoginCont -> modifyPw");
		service.modifyUserPw(m);
		return "main";
	}
	@RequestMapping(value="/logincont/delete.do")
	public String deleteUser(@RequestParam(value="num")int num, HttpSession hs){
		System.out.println("LoginCont -> deleteUserInfo");
		service.dropUserInfo(num);
		hs.invalidate();
		return "main";
	}
}
