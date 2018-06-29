package com.guoguo.manager;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.guoguo.model.TbGoods;
import com.guoguo.model.TbGoodsUpdate;

public class TestManagerImpl implements TestManager {

	Map<String, TbGoods> goodsMap = new HashMap<String, TbGoods>();

	Map<String, TbGoodsUpdate> goodsUpdateMap = new HashMap<String, TbGoodsUpdate>();

	public TestManagerImpl(List<TbGoods> goodsList) {
		TbGoods goods = null;
		for (int i = 1; i <= 20; i++) {
			goods = new TbGoods();
			goods.setGoodsName("电脑桌");
			goods.setPrice(new BigDecimal(120));
			goods.setOffice("");
			goods.setStatus(1);
			goods.setType(1);
			if (i / 2 == 0) {
				goods.setColor(1);
				goods.setDesc("160cm");
				goods.setGoodsId(i + "");
			} else {
				goods.setColor(2);
				goods.setDesc("120cm");
				goods.setGoodsId(i + "");
			}
			goodsMap.put(goods.getGoodsId(), goods);
		}

		for (int i = 21; i <= 40; i++) {
			goods = new TbGoods();
			goods.setGoodsName("电脑椅");
			goods.setPrice(new BigDecimal(120));
			goods.setOffice("");
			goods.setStatus(1);
			goods.setType(1);
			if (i / 2 == 0) {
				goods.setColor(1);
				goods.setGoodsId(i + "");
			} else {
				goods.setColor(2);
				goods.setGoodsId(i + "");
			}
			goodsMap.put(goods.getGoodsId(), goods);
		}
	}

	@Override
	public void insertGoods(List<TbGoods> goodsList) {
		// TODO Auto-generated method stub
		for (TbGoods goods : goodsList) {
			goodsMap.put(goods.getGoodsId(), goods);
		}
	}

	@Override
	public Integer updateGoods(List<TbGoods> goodsList) {
		/**
		 * 实现思路：
		 *      1、选取需要分配的资产，并录入要分配的办公室 （这里采取的是字段复制，最好是有资产表与办公室表的分配关联表）
		 */
		for (TbGoods goods : goodsList) {
			TbGoods target = goodsMap.get(goods.getGoodsId());
			target.setOffice(goods.getOffice());
			goodsMap.put(goods.getGoodsId(), target);
		}
		return 1;
	}

	@Override
	public List<TbGoods> queryGoodsByBad(Integer goodsStatus) {
		/**
		 * 实现思路：
		 *      1、查询需要维修的资产
		 */
		List<TbGoods> list = new LinkedList<TbGoods>();
		for (TbGoods entry : goodsMap.values()) {
			// 3表示待维修
			if (goodsStatus == entry.getStatus()) {
				list.add(entry);
			}
		}
		return list;
	}

	@Override
	public Integer ModifyGoods(List<String> goodsIdList) {
		// TODO Auto-generated method stub
		/**
		 * 实现思路：
		 *      1、根据传值需要维修的资产，匹配相同规格的资产。
		 *      2、需要维修的资产放入维修表，
		 *      3、仓库删除需要维修的资产，加入同规格的资产
		 */
		TbGoods tbGoods = null;
		TbGoodsUpdate goodsUpdate = null;
		for (String goodsId : goodsIdList) {
			tbGoods = goodsMap.get(goodsId);
			goodsUpdate = new TbGoodsUpdate();
			copyObject(tbGoods, goodsUpdate);

			goodsUpdateMap.put(goodsId, goodsUpdate);

			tbGoods.setGoodsId(goodsMap.size() + 1 + "");
			goodsMap.remove(goodsId);
			goodsMap.put(tbGoods.getGoodsId(), tbGoods);

		}
		return 1;
	}

	private void copyObject(TbGoods tbGoods, TbGoodsUpdate goodsUpdate) {
		// TODO Auto-generated method stub
		goodsUpdate.setGoodsName(tbGoods.getGoodsName());
		goodsUpdate.setPrice(tbGoods.getPrice());
		goodsUpdate.setOffice(tbGoods.getOffice());
		goodsUpdate.setStatus(tbGoods.getStatus());
		goodsUpdate.setType(tbGoods.getType());
		goodsUpdate.setColor(tbGoods.getColor());
		goodsUpdate.setDesc(tbGoods.getDesc());
		goodsUpdate.setGoodsId(tbGoods.getGoodsId());
		goodsUpdate.setColor(tbGoods.getColor());
		goodsUpdate.setDesc(tbGoods.getDesc());
	}

}
