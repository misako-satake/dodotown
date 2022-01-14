package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Item;
import com.example.demo.repository.ItemMapper;

/**
 * 
 * @author satakemisako
 *商品リスト表示用サービスクラス
 */

@Service
public class ItemShowService {

	@Autowired
	private ItemMapper mapper;
	
	public List<Item> findByItems(){
		List<Item> itemlist = mapper.findByItems();
		return itemlist;
	}
	
	public List<Item> findItemsByKeywords(String[] keywords){
		List<Item> itemlist = mapper.findItemsByKeywords(keywords);
		return itemlist;
	}
	
	public List<Item> findItemsOfShopByKeywords(String[] keywords){
		List<Item> itemlist = mapper.findItemsOfShopByKeywords(keywords);
		return itemlist;
	}
	
	public List<Item> findItemById(Integer itemId) {
		List<Item> itemlist = mapper.findItemById(itemId);
		return itemlist;
	}
	
}
