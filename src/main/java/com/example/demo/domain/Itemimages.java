package com.example.demo.domain;

import lombok.Data;

/**
 * 
 * @author satakemisako
 *商品画像テーブルのドメイン
 */
@Data
public class Itemimages {

	private int id;
	private int goodsId;
	private String imagePath;
	
	
	@Override
	public String toString() {
		return "Itemimages [id=" + id + ", goodsId=" + goodsId + ", imagePath=" + imagePath + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
