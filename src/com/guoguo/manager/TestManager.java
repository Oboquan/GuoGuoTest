package com.guoguo.manager;

import java.util.List;

import com.guoguo.model.TbGoods;

public interface TestManager {

	/**����ʲ�*/
	void insertGoods(List<TbGoods> goodsList);
	
	/**�����ʲ�*/
	Integer updateGoods(List<TbGoods> goodsList);
	
	/**��ѯ��Ҫά�޵��ʲ�*/
	List<TbGoods> queryGoodsByBad(Integer goodsStatus);
	
	/**ά���ʲ�*/
	Integer ModifyGoods(List<String> goodsIdList);
}
