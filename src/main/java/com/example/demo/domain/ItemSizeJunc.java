package com.example.demo.domain;
/**
 * 
 * @author satakemisako
 * サイズテーブルとアイテムテーブルの中間テーブル
 *
 */
public class ItemSizeJunc {

	private Integer id;
	private Integer juncGoodsId;
	private Integer juncSizeId;
	
	
	@Override
	public String toString() {
		return "ItemSizeJunc [id=" + id + ", juncGoodsId=" + juncGoodsId + ", juncSizeId=" + juncSizeId + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJuncGoodsId() {
		return juncGoodsId;
	}
	public void setJuncGoodsId(Integer juncGoodsId) {
		this.juncGoodsId = juncGoodsId;
	}
	public Integer getJuncSizeId() {
		return juncSizeId;
	}
	public void setJuncSizeId(Integer juncSizeId) {
		this.juncSizeId = juncSizeId;
	}
}
