package com.guoguo.model;

import java.math.BigDecimal;

/**
 * �ʲ���
 * @author EC_Troy
 */
public class TbGoods {

	/**�ʲ�Id*/
	private String goodsId;
	
	/**�ʲ�Name*/
	private String goodsName;
	
	/**��ɫ 1"white" : 2"black"*/
	private Integer color;
	
	/**���*/
	private String desc;
	
	/**���� 1"������" : 2"������"*/
	private Integer type;
	
	/**���*/
	private BigDecimal price;
	
	/**״̬  1������  2���ѷ���  3����ά��*/
	private Integer status;
	
	/**������İ칫��*/
	private String office;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
