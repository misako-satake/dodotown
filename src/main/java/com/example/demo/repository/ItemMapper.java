package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.CartItem;
import com.example.demo.domain.Item;

/**
 * 
 * @author satakemisako
 *商品情報に関してitemsテーブルにアクセスするためのマッパークラス
 */

@Mapper
public interface ItemMapper {

	public List<Item> findByItems();
	public List<Item> findItemsByKeywords(@Param("keywords") String[] keywords);
	public List<Item> findItemsOfShopByKeywords(@Param("keywords") String[] keywords);
	public List<Item> findItemById(Integer itemId);
	public void insertItemToCart(CartItem cartitem);
	public void reduceStock(@Param("stockCount") Integer stockCount, @Param("itemId") Integer itemId);
	
	
}
