package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.CartItem;
import com.example.demo.domain.Item;
import com.example.demo.form.OrderForm;
import com.example.demo.service.ItemOrderService;
import com.example.demo.service.ItemShowService;

/**
 * 
 * @author satakemisako
 * ショッピングカート関連のコントローラークラス
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ItemOrderService service;
	
	@Autowired
	private ItemShowService showservice;
	
	@Autowired
	private HttpSession session;
	
	
	
	@RequestMapping("/toCart")
	public String toCart() {
		
		String userId = (String) session.getAttribute("emailAddress");
		List<CartItem> cartitemlist = new ArrayList<>();
		if(userId == null) {
			cartitemlist = service.findCartItem("nonId");//カートの中身の結果を全件検索
		}else {
			cartitemlist = service.findCartItem(userId);//カートの中身の結果を全件検索
//		cartitemlist.forEach(i -> System.out.println(i));
		}
		session.setAttribute("cartitemlist", cartitemlist);
		
		Integer totalpriceincart = calcTotalPrice(cartitemlist);//合計金額計算
		session.setAttribute("totalpriceincart", totalpriceincart);
		
		return "cart/shoppingcart";
	}
	
	@RequestMapping("/order")
	public String order(OrderForm form,String userEmail,Model model) {
		List<Item> items = showservice.findItemById(form.getItemId());
		for(Item item:items) {
			System.out.println("現在の在庫："+item.getStockCount());
			if(item.getStockCount()<=0) {
				model.addAttribute("stockzero", "完売しました");
			}
		}
				
		
		CartItem cartitem = new CartItem();
		
		if(userEmail==null) {//ユーザーのログイン有無確認
			form.setUserId("nonId");//未ログインの場合、UserIdを統一
		}else {
			form.setUserId(userEmail);//ログイン済みの場合、UserIdにアドレスをセット
			System.out.println(userEmail);
		}
		//フォームからドメインに詰め替え
		BeanUtils.copyProperties(form,cartitem);
		
		//商品数の追加
				//カート内にある同じ商品を検索
				List<CartItem> samecartitemlist = service.findCartItemByIdAndSize(form.getItemId(), form.getItemSize());
				if(samecartitemlist.size()!=0) {//カートが空ではない場合
						for(CartItem samecartitem : samecartitemlist) {
							if(samecartitem.getNumberOfItems()==null) {//既に同じ商品がカートにある場合
								cartitem.setNumberOfItems(1);
								System.out.println("here!!!!");
								service.addNumberOfItem(cartitem.getNumberOfItems(), cartitem.getItemId(), cartitem.getItemSize());
							}
							else {//同じ商品がまだカートにない場合
								int newNumOfItem = samecartitem.getNumberOfItems();
								newNumOfItem++;
								cartitem.setNumberOfItems(newNumOfItem);
								service.addNumberOfItem(cartitem.getNumberOfItems(), cartitem.getItemId(), cartitem.getItemSize());
							}
						}
				}else {//カートが空の場合
					cartitem.setNumberOfItems(1);
					service.insertItemToCart(cartitem);
				}
		//追加したカート内の結果を取得し、セッションスコープに格納
		List<CartItem> cartitemlist = new ArrayList<>();
		if(userEmail == null) {
			cartitemlist = service.findCartItem("nonId");//未ログイン時のカートの中身を全件検索
		}else {
			cartitemlist = service.findCartItem(userEmail);//ユーザーIDに紐づくカートの中身の結果を全件検索
		}
		session.setAttribute("cartitemlist", cartitemlist);
		
		Integer totalpriceincart = calcTotalPrice(cartitemlist);//合計金額計算メソッド呼び出し
		session.setAttribute("totalpriceincart", totalpriceincart);
		
		return "cart/shoppingcart";
	}
	
	@RequestMapping("/addNumberOfItems")
	public String changeNumberOfItems(Integer numberOfItems, Integer itemId, String itemSize) {
		System.out.println(numberOfItems + "です");
		numberOfItems++;
		service.addNumberOfItem(numberOfItems,itemId,itemSize);
		return "cart/shoppingcart";
	}
	
	//合計金額計算用メソッド
	public Integer calcTotalPrice(List<CartItem> cartitemlist) {
		Integer totalPrice = 0;
		for(CartItem cartitem: cartitemlist) {
			totalPrice = totalPrice + cartitem.getItemPrice()*cartitem.getNumberOfItems();
		}
		
		return totalPrice;
	}
	
	
}
