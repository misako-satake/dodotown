package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Item;
import com.example.demo.service.ItemShowService;
/**
 * 
 * @author satakemisako
 * ショップ検索用オートコンプリートコントローラークラス
 *
 */
@RestController
@RequestMapping("")
public class AutoCompleteApiController {

	@Autowired
	private ItemShowService service;
	
	@GetMapping("/showShopResultByKeywords")
	public List<String> showShopResultByKeywords(){
		  List<Item> allitemlist = service.findByItems();
		  
		  //ショップ名のみ取り出してリストに詰める
		  List<String> shopnamelist = new ArrayList<>();
		  for(Item item : allitemlist) {
			  shopnamelist.add(item.getShopName());
		  }
		  return shopnamelist;
	}
	
}
