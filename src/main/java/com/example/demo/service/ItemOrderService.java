package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CartItem;
import com.example.demo.repository.CartItemMapper;
import com.example.demo.repository.ItemMapper;

/**
 * 
 * @author satakemisako
 * 商品購入のためのサービスクラス
 *
 */
@Service
public class ItemOrderService {

	@Autowired
	private ItemMapper mapper;
	
	@Autowired
	private CartItemMapper cmapper;
	
	
	public void insertItemToCart(CartItem cartitem) {
		mapper.insertItemToCart(cartitem);
	}
	
	public List<CartItem> findCartItem(String userId){
		List<CartItem> catitemlist = cmapper.findCartItem(userId);
		return catitemlist;
	}
	
	public void addNumberOfItem(Integer numberOfItems, Integer itemId, String itemSize) {
		cmapper.addNumberOfItem(numberOfItems,itemId,itemSize);
	}
	
	public List<CartItem> findCartItemByIdAndSize(Integer itemId, String itemSize){
		List<CartItem> cartitemlist = cmapper.findCartItemByIdAndSize(itemId, itemSize);
		return cartitemlist;
	}
	
	public void reduceStock(Integer stockCount, Integer itemId) {
		mapper.reduceStock(stockCount, itemId);
	}
	
	public void deleteAllItemIncart(String userId) {
		cmapper.deleteAllItemIncart(userId);
	}
	
}
