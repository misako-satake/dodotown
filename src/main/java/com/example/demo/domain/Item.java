package com.example.demo.domain;

import java.util.List;

import lombok.Data;

@Data
public class Item {

	private int itemId;
	private int goodsId;
	private int itemPrice;
	private String itemColor;
	private String itemName;
	private String itemDescription;
	private String shopName;
	private int gender;
	private boolean deleted;
	private int stockCount;
	private List<Itemimages> itemimageslist;
	private List<ItemSizeJunc> itemsizejunclist;
	private List<ItemSize> itemsizelist;
	
	
	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", goodsId=" + goodsId + ", itemPrice=" + itemPrice + ", itemColor="
				+ itemColor + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", shopName="
				+ shopName + ", gender=" + gender + ", deleted=" + deleted + ", stockCount=" + stockCount
				+ ", itemimageslist=" + itemimageslist + ", itemsizejunclist=" + itemsizejunclist + ", itemsizelist="
				+ itemsizelist + "]";
	}
	
	
	public List<ItemSizeJunc> getItemsizejunclist() {
		return itemsizejunclist;
	}
	public void setItemsizejunclist(List<ItemSizeJunc> itemsizejunclist) {
		this.itemsizejunclist = itemsizejunclist;
	}
	public List<ItemSize> getItemsizelist() {
		return itemsizelist;
	}
	public void setItemsizelist(List<ItemSize> itemsizelist) {
		this.itemsizelist = itemsizelist;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public List<Itemimages> getItemimageslist() {
		return itemimageslist;
	}
	public void setItemimageslist(List<Itemimages> itemimageslist) {
		this.itemimageslist = itemimageslist;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemColor() {
		return itemColor;
	}
	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
}
