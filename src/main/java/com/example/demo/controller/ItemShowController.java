package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Item;
import com.example.demo.domain.Itemimages;
import com.example.demo.form.SearchKeywordsForm;
import com.example.demo.service.ItemShowService;

/**
 * 
 * @author satakemisako
 *商品リスト表示用コントローラークラス
 */
@Controller
@RequestMapping("/itemlist")
public class ItemShowController {

	@Autowired
	private ItemShowService service;
	
	@RequestMapping("")
	public String test() {
		return "test/test";
	}
	
	@RequestMapping("/toTopPage")
	public String toTopPage() {
		return "item/toppage";
	}
	
	@RequestMapping("/showAll")
	public String showAll(Model model) {
		List<Item> itemlist = service.findByItems();
		for(Item item : itemlist) {
			System.out.println(item.getStockCount());
			List<Itemimages> imageslist = item.getItemimageslist();
			for(Itemimages image : imageslist) {
				System.out.println(image);
			}
		}
		model.addAttribute("allitemlist", itemlist);
		
		return "item/itemslist";
	}
	
//	@RequestMapping("/showResultByKeywords")
//	public String showSearchResult(String keywords,Model model) {
//		System.out.println(keywords);
//		List<Item> itemlist = service.findItemsByKeywords(keywords);
//		
//		if(itemlist.size()==0) {
//			model.addAttribute("resultzeromessage", "条件に一致する商品は見つかりませんでした");
//		}else {
//			for(Item item : itemlist) {
//				List<Itemimages> imageslist = item.getItemimageslist();
//				for(Itemimages image : imageslist) {
//					System.out.println("image:"+image);
//				}
//			}
//			model.addAttribute("allitemlist", itemlist);
//		}
//		
//		return "item/itemslist";
//	}
	
	@RequestMapping("/showResultByKeywords")
	public String search(SearchKeywordsForm form,Model model) {
		  String keywords = form.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		  String[] keywordscolection = keywords.split(" ");
		  
		  List<Item> allitemlist = service.findItemsByKeywords(keywordscolection);
		  
		  if(allitemlist.size()==0) {
				model.addAttribute("resultzeromessage", "条件に一致する商品は見つかりませんでした");
			}else {
				model.addAttribute("allitemlist", allitemlist);
			}
		  
		  return "item/itemslist";
	}
	
	//ショップ名検索画面表示用メソッド
	@RequestMapping("toSearchByShop")
	public String toSearchByShop() {
		return "item/searchbyshop";
	}
	
	//ショップ名からのアイテム検索メソッド
	@RequestMapping("searchByShop")
	public String searchByShop(SearchKeywordsForm form,Model model) {
		String keywords = form.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		  String[] keywordscolection = keywords.split(" ");
		  
		  List<Item> allitemlist = service.findItemsOfShopByKeywords(keywordscolection);
		  
		  if(allitemlist.size()==0) {
				model.addAttribute("resultzeromessage", "条件に一致する商品は見つかりませんでした");
			}else {
				model.addAttribute("allitemlist", allitemlist);
				Item item =allitemlist.get(0);
				model.addAttribute("shopname", item.getShopName());
			}
		return "item/itemlistbyshop";
	}
	
	@RequestMapping("/toItemDetail")
	public String toItemDetail(Integer itemId,Model model) {
		model.addAttribute("itemId", itemId);
		
		//商品詳細を表示させる
				List<Item> item = service.findItemById(itemId);
				model.addAttribute("item", item);
				
		return "item/itemdetail";
	}
	
	
	
}
