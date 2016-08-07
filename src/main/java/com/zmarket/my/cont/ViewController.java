package com.zmarket.my.cont;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zmarket.my.board.BenchBoard;
import com.zmarket.my.board.BenchBoardService;
import com.zmarket.my.category.Category;
import com.zmarket.my.category.CategoryService;
import com.zmarket.my.login.LoginService;
import com.zmarket.my.login.Member;
import com.zmarket.my.order.Baskets;
import com.zmarket.my.order.Order;
import com.zmarket.my.order.OrderService;
import com.zmarket.my.order.Orders;
import com.zmarket.my.product.ProductService;
import com.zmarket.my.product.Products;

@Controller
public class ViewController {
	@Resource(name="orderService")
	private OrderService orderService;
	@Resource(name="loginService")
	private LoginService loginService;
	@Resource(name="BenchBoardService")
	private BenchBoardService benchService;
	@Resource(name="productService")
	private ProductService productService;
	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setBenchService(BenchBoardService benchService) {
		this.benchService = benchService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession hs) { //Main Page View
		return "redirect:/viewcont/main.do";
	}
	@RequestMapping(value="/viewcont/main.do")
	public ModelAndView main(HttpSession hs){
		System.out.println("viewCont -> get Main Datas");
		ModelAndView mav = new ModelAndView("main");
		if(hs.getAttribute("num") != null) {
			int num = Integer.parseInt(hs.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
		}
		List<Products> plist = productService.getProductsByDate();
		if(plist.size() != 0)
			mav.addObject("PLIST", plist);
		else
			mav.addObject("PLIST", null);
		return mav;
	}
	@RequestMapping(value="/viewcont/loginform.do")
	public ModelAndView loginForm(HttpSession hs){ //Login Page View
		ModelAndView mav = new ModelAndView("login/login");
		if(hs.getAttribute("num") != null) {
			int num = Integer.parseInt(hs.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
		}
		return mav;
	}
	@RequestMapping(value="/viewcont/myform.do")
	public ModelAndView myForm(HttpSession hs){ //MyPage View
		ModelAndView mav = new ModelAndView("login/mypage");
		if(hs.getAttribute("num") != null) {
			int num = Integer.parseInt(hs.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
		}
		return mav;
	}
	@RequestMapping(value="/viewcont/jointype.do")
	public String joinType(HttpSession hs){ //Jointype Page View
		hs.setAttribute("num", hs.getAttribute("num"));
		return "login/jointype";
	}
	@RequestMapping(value="/viewcont/joinformcustomer.do")
	public String joinFormCustomer(HttpSession hs){ //Join-customer Page View
		hs.setAttribute("num", hs.getAttribute("num"));
		return "login/joincustomer";
	}
	@RequestMapping(value="/viewcont/joinformseller.do")
	public String joinFormseller(HttpSession hs){ //Join-seller Page View
		hs.setAttribute("num", hs.getAttribute("num"));
		return "login/joinseller";
	}
	@RequestMapping(value="/viewcont/myorderform.do")
	public ModelAndView myOrderForm(@RequestParam(value="blist")int[] blist, HttpSession hs){ //Customer - 주문내역 페이지
		System.out.println("viewCont -> myOrderinfo"); 
		//주문정보 가져오기
		ModelAndView mav = new ModelAndView("purchase/orderinfo");
		if(hs.getAttribute("num") != null) {
			int num = Integer.parseInt(hs.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
			mav.addObject("OLIST", orderService.findListByCustomer_num(num));
		}
		return mav;
	}
	@RequestMapping(value="/viewcont/myorderinfo.do")
	public ModelAndView myOrderInfo(HttpSession hs){
		System.out.println("viewCont -> myOrderinfo"); 
		//주문정보 가져오기
		ModelAndView mav = new ModelAndView("purchase/orderinfo");
		if(hs.getAttribute("num") != null) {
			int num = Integer.parseInt(hs.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
			List<Orders> olist = orderService.findListByCustomer_num(num);
			if(olist.size() != 0){
				mav.addObject("OLIST", olist);
				List<Orders> tolist = orderService.findOrderList(num);
				mav.addObject("TOLIST", tolist);
			}
			else
				mav.addObject("OLIST", null);
		}
		return mav;
	}
	@RequestMapping(value="/viewcont/myorderstateform.do")
	public ModelAndView myOrderStateForm(HttpSession hs){ //Customer - 주문정보 페이지
		System.out.println("viewCont -> myOrderstateForm");
		
		//주문정보 가져오기
		ModelAndView mav = new ModelAndView("purchase/orderstatement");
		if(hs.getAttribute("num") != null) {
			int num = Integer.parseInt(hs.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
			mav.addObject("OLIST", orderService.findListByCustomer_num(num));
		}	
		return mav;
	}
	@RequestMapping(value="/viewcont/mybasketform.do")
	public ModelAndView myBasketForm(HttpSession hs){ //장바구니 페이지
		System.out.println("viewCont -> myBasketForm");
		
		//장바구니 정보 가져오기
		ModelAndView mav = new ModelAndView("purchase/mybasket");
		if(hs.getAttribute("num") != null) {
			int num = Integer.parseInt(hs.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
			
			List<Baskets> BLIST = orderService.findBasketsByCustomer_num(num);
			
			if(BLIST.size() != 0){
				mav.addObject("BLIST", BLIST);
			}else{
				mav.addObject("BLIST", null);
			}
		}	
		return mav;
	}
	@RequestMapping(value="/viewcont/showitem.do")
	public ModelAndView showItemPage(@RequestParam(value="prod_num")int prod_num, HttpSession hs){ //선택한 상품에 대한 페이지
		System.out.println("viewCont -> itemPage");
		ModelAndView mav = new ModelAndView("seller/item");
		//Product정보 불러오기
		Products p = productService.getProducts(prod_num);
		String[] options = p.getOption_indexes().split("/");
		ArrayList<String[]> option = new ArrayList<String[]>();
		for(String str : options) {
			option.add(str.split(","));
		}
		mav.addObject("OPTIONS", option);
		int num;
		Member m = null;
		
		if(hs.getAttribute("num") != null) {
			num = Integer.parseInt(hs.getAttribute("num").toString());
			m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
		}
		List<BenchBoard> bolist = benchService.getBenchBoardByProdNum(prod_num);
		
		mav.addObject("P", p);
		if(bolist.size() != 0)
			mav.addObject("BOLIST", bolist);
		else
			mav.addObject("BOLIST", null);
		return mav;
	}
	@RequestMapping(value="/viewcont/catesearch.do")//카테고리로 상품 검색
	public ModelAndView category_Search(@RequestParam(value="type")int category_num, HttpSession hs){
		System.out.println("viewCont -> search to Category");
		ModelAndView mav = new ModelAndView("search/searchpage");
		int num;
		if(hs.getAttribute("num") != null){
			num = (Integer) hs.getAttribute("num");
			hs.setAttribute("num", num);
		}
		List<Products> plist = productService.getProductsByCategory(category_num);
		Category c = categoryService.getCategory(category_num);
		mav.addObject("searchData", c.getName());
		if(plist.size() != 0)
			mav.addObject("PLIST", plist);
		else
			mav.addObject("PLIST", null);
		return mav;
	}
}
