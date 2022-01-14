package com.example.demo.domain;

import java.util.List;

public class CartItem {

	private Integer itemId;
	private Integer numberOfItems;
	private Integer itemPrice;
	private String  itemColor;
	private String  itemSize;
	private String  itemName;
	private String  shopName;
	private String  userId;
	private List<Itemimages> itemimageslist;
	private List<ItemSize> itemsizelist;
	
	
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", numberOfItems=" + numberOfItems + ", itemPrice=" + itemPrice
				+ ", itemColor=" + itemColor + ", itemSize=" + itemSize + ", itemName=" + itemName + ", shopName="
				+ shopName + ", userId=" + userId + ", itemimageslist=" + itemimageslist + ", itemsizelist="
				+ itemsizelist + "]";
	}
	
	public List<ItemSize> getItemsizelist() {
		return itemsizelist;
	}
	public void setItemsizelist(List<ItemSize> itemsizelist) {
		this.itemsizelist = itemsizelist;
	}
	public List<Itemimages> getItemimageslist() {
		return itemimageslist;
	}
	public void setItemimageslist(List<Itemimages> itemimageslist) {
		this.itemimageslist = itemimageslist;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemColor() {
		return itemColor;
	}
	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
