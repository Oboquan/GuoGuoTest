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
			goods.setGoodsName("������");
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
			goods.setGoodsName("������");
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
		 * ʵ��˼·��
		 *      1��ѡȡ��Ҫ������ʲ�����¼��Ҫ����İ칫�� �������ȡ�����ֶθ��ƣ���������ʲ�����칫�ұ�ķ��������
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
		 * ʵ��˼·��
		 *      1����ѯ��Ҫά�޵��ʲ�
		 */
		List<TbGoods> list = new LinkedList<TbGoods>();
		for (TbGoods entry : goodsMap.values()) {
			// 3��ʾ��ά��
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
		 * ʵ��˼·��
		 *      1�����ݴ�ֵ��Ҫά�޵��ʲ���ƥ����ͬ�����ʲ���
		 *      2����Ҫά�޵��ʲ�����ά�ޱ�
		 *      3���ֿ�ɾ����Ҫά�޵��ʲ�������ͬ�����ʲ�
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
