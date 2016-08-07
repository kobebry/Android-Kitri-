package com.zmarket.my.cont;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zmarket.my.login.LoginService;
import com.zmarket.my.login.Member;
import com.zmarket.my.order.Basket;
import com.zmarket.my.order.BasketBundle;
import com.zmarket.my.order.Order;
import com.zmarket.my.order.OrderService;
import com.zmarket.my.product.Product;
import com.zmarket.my.product.ProductBundle;
import com.zmarket.my.product.ProductService;
import com.zmarket.my.product.Products;
import com.zmarket.my.product.img.ProductImg;
import com.zmarket.my.product.img.ProductImgService;
import com.zmarket.my.product.opt.ProductOpt;
import com.zmarket.my.product.opt.ProductOptService;

@Controller
public class CustomerController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	@Resource(name="orderService")
	private OrderService orderService;
	
	@Resource(name="productService")
	private ProductService productService;
	
	@Resource(name="productImgService")
	private ProductImgService productImgService;
	
	@Resource(name="productOptService")
	private ProductOptService productOptService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public void setProductImgService(ProductImgService productImgService) {
		this.productImgService = productImgService;
	}

	public void setProductOptService(ProductOptService productOptService) {
		this.productOptService = productOptService;
	}

	@RequestMapping(value="/custcont/search.do") //검색입력시 동작기능
	public ModelAndView SearchPage(@RequestParam(value="searchData")String searchData, HttpSession hs) {
		System.out.println("custCont -> search : "+searchData);
		int num = 0;
		Member m = null;
		ModelAndView mav = new ModelAndView("search/searchpage");
		if(hs.getAttribute("num") != null) {
			num = Integer.parseInt(hs.getAttribute("num").toString());
			m = loginService.getUserInfo(num);
			hs.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
		}
		List<Products> plist = productService.getProductsByName(searchData);
		
		mav.addObject("searchData", searchData);
		if(plist.size() != 0)
			mav.addObject("PLIST", plist);
		else
			mav.addObject("PLIST", null);
		return mav;
	}
	@RequestMapping(value="/custcont/addbasket.do") //장바구니에 담기
	public ModelAndView addBasket(Basket b, HttpSession hs){
		System.out.println("custCont -> addBasket");
		int num = (Integer) hs.getAttribute("num");
		ModelAndView mav = new ModelAndView("JSON/addbasketCheckJSON");
		b.setAmount(1);b.setCustomer_num(num);
		orderService.addBasket(b);
		mav.addObject("check", 1);
		return mav;
	}
	
	@RequestMapping(value="/custcont/orderProduct.do")
	public ModelAndView orderProduct(@RequestParam(value="prod_num")int prod_num, @RequestParam(value="opt_num")int[] opt_num, @RequestParam(value="amount")int[] amount, HttpSession session) {
		Product product = productService.getProduct(prod_num);
		int price = product.getPrice();
		ProductImg productImg = productImgService.getAllProductImgs(prod_num).get(0);
		ArrayList<Basket> basketList = new ArrayList<Basket>();
		for(int i = 0; i < opt_num.length; i++) {
			Basket basket = new Basket();
			basket.setProd_num(prod_num);
			basket.setAmount(amount[i]);
			ProductOpt po = productOptService.getProductOpt(opt_num[i]);
			basket.setProd_opt_options(po.getOptions());
			basket.setProd_opt_num(opt_num[i]);
			basketList.add(basket);
			price += po.getAdditional_price();
		}
		Member member = loginService.getUserInfo(Integer.parseInt(session.getAttribute("num").toString()));
		ModelAndView mav = new ModelAndView("purchase/orderForm");
		mav.addObject("PRODUCT", product);
		mav.addObject("PROD_IMG", productImg);
		mav.addObject("BASKETS", basketList);
		mav.addObject("MEMBER", member);
		mav.addObject("PRICE", price);
		if(session.getAttribute("num") != null) {
			int num = Integer.parseInt(session.getAttribute("num").toString());
			Member m = loginService.getUserInfo(num);
			session.setAttribute("num", num);
			mav.addObject("TYPE", m.getType());
		}
		return mav; 
	}
	
	@RequestMapping(value="/custcont/orderProducts.do")
	public ModelAndView orderProducts(HttpSession session, @RequestParam(value="blist")int[] blist) {
		int price = 0;
		int totalAmount = 0;
		ArrayList<Integer> productNumList = new ArrayList<Integer>();
		ArrayList<ProductBundle> prodBundleList = new ArrayList<ProductBundle>();
		for(int i : blist) {
			Basket basket = orderService.getBasket(i);
			ProductBundle paib = new ProductBundle();
			paib.setProduct(productService.getProduct(basket.getProd_num()));
			productNumList.add(paib.getProduct().getNum());
			paib.setProductImg(productImgService.getAllProductImgs(basket.getProd_num()).get(0));
			ProductOpt productOpt = productOptService.getProductOpt(basket.getProd_opt_num());
			basket.setProd_opt_options(productOpt.getOptions());
			paib.setBasket(basket);
			
			price += (basket.getAmount() * productOpt.getAdditional_price());
			if(!productNumList.contains(paib.getProduct().getNum())) {
				price += paib.getProduct().getPrice();
			}
			
			totalAmount += basket.getAmount();
			prodBundleList.add(paib);
		}
		
		ModelAndView mav = new ModelAndView("purchase/orderFormForBasket");
		mav.addObject("PROD_BUNDLES", prodBundleList);
		mav.addObject("MEMBER", loginService.getUserInfo(Integer.parseInt(session.getAttribute("num").toString())));
		mav.addObject("TOTAL_AMOUNT", totalAmount);
		mav.addObject("PRICE", price);
		return mav;
	}
	
	@RequestMapping(value="/custcont/payment.do")
	public String payment(@RequestParam(value="address")String address, @RequestParam(value="phone")String phone, BasketBundle bb) {
		System.out.println(address);
		System.out.println(phone);
		for(Basket basket : bb.getBasketList()) {
			// 옵션에 해당 amount만큼 차감
			productOptService.decreaseAmount(basket.getProd_opt_num(), basket.getAmount());
			
			Order order = new Order();
			order.setProd_num(basket.getProd_num());
			order.setProd_opt_num(basket.getProd_opt_num());
			order.setCustomer_num(basket.getCustomer_num());
			order.setAmount(basket.getAmount());
			order.setAddress(address);
			order.setPhone(phone);
			orderService.addOrder(order);
		}
		return "redirect:/viewcont/myorderinfo.do";
	}
}
