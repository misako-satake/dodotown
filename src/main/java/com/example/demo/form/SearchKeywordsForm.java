package com.example.demo.form;
/**
 * 
 * @author satakemisako
 * 全商品から複数単語で検索する際のキーワード入力用フォーム
 *
 */
public class SearchKeywordsForm {
	
	private String keywords;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "SearchKeywordsForm [keywords=" + keywords + "]";
	}
	
	
}
