package com.example.demo.domain;

public class ItemSize {

	private String sizeName;
	private Integer sizeId;
	
	
	@Override
	public String toString() {
		return "ItemSize [sizeName=" + sizeName + ", sizeId=" + sizeId + "]";
	}
	
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public Integer getSizeId() {
		return sizeId;
	}
	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}
	
	
	
}
