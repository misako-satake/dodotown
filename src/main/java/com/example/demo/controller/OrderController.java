package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.LineNotify;
import com.example.demo.domain.CartItem;
import com.example.demo.domain.Item;
import com.example.demo.service.ItemOrderService;
import com.example.demo.service.ItemShowService;

/**
 * 
 * @author satakemisako
 * 商品注文確定用コントローラー
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private ItemOrderService service;
	
	@Autowired
	private ItemShowService showservice;
	
	public final LineNotify linesubmit = new LineNotify(null);
	
	@RequestMapping("/toConfirmOrder")
	public String toConfirmOrder() {
		return "cart/confirmorder";
	}
	
	@RequestMapping("/toInputOrderInfo")
	public String toInputOrderInfo() {
		return "cart/inputorderinfo";
	}
	
	@RequestMapping("/toCompleteOrder")
	public String toCompleteOrder() {
		return "cart/ordercomplete";
	}
	
	//カートを空っぽにし、在庫を購入した数量分減らすメソッド
	@RequestMapping("/reduceStock")
		public String reduceStock() {
			List<CartItem> cartitemlist = (List<CartItem>)session.getAttribute("cartitemlist");
			
			for(CartItem cartitem : cartitemlist) {
				List<Item> itemlist = showservice.findItemById(cartitem.getItemId());
				for(Item item : itemlist) {
					Integer carentStockCount = item.getStockCount();
					Integer newStockCount = carentStockCount-(cartitem.getNumberOfItems());
					System.out.println(newStockCount);
					
						service.reduceStock(newStockCount, item.getItemId());
						linesubmit.line(item.getItemName(),cartitem.getNumberOfItems(),newStockCount);
						
				}
			}
			
			String userId = (String) session.getAttribute("emailAddress");
			if(userId==null) {
				service.deleteAllItemIncart("nonId");
			}else {
				service.deleteAllItemIncart(userId);
			}
			
			
			return "cart/ordercomplete";
	}
}
