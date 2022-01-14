package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.CartItem;

/**
 * 
 * @author satakemisako
 * 商品購入に関するリポジトリクラス
 *
 */
@Mapper
public interface CartItemMapper {

	//カート内商品全件検索
	public List<CartItem> findCartItem(String userId);
	//購入商品数の追加
	public void addNumberOfItem(@Param("numberOfItems") Integer numberOfItems,
			@Param("itemId") Integer itemId, @Param("itemSize") String itemSize);
	//カート内にある同じ商品の検索
	public List<CartItem> findCartItemByIdAndSize(@Param("itemId") Integer itemId, @Param("itemSize") String itemSize);
	//カート内商品の削除
	public void deleteAllItemIncart(String userId);
	
}
