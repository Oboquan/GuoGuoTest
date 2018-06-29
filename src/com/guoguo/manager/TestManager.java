package com.guoguo.manager;

import java.util.List;

import com.guoguo.model.TbGoods;

public interface TestManager {

	/**存放资产*/
	void insertGoods(List<TbGoods> goodsList);
	
	/**分配资产*/
	Integer updateGoods(List<TbGoods> goodsList);
	
	/**查询需要维修的资产*/
	List<TbGoods> queryGoodsByBad(Integer goodsStatus);
	
	/**维修资产*/
	Integer ModifyGoods(List<String> goodsIdList);
}
