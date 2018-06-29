package com.guoguo.model;

import java.math.BigDecimal;

/**
 * 资产类
 * @author EC_Troy
 */
public class TbGoods {

	/**资产Id*/
	private String goodsId;
	
	/**资产Name*/
	private String goodsName;
	
	/**颜色 1"white" : 2"black"*/
	private Integer color;
	
	/**规格*/
	private String desc;
	
	/**类型 1"电脑桌" : 2"电脑椅"*/
	private Integer type;
	
	/**金额*/
	private BigDecimal price;
	
	/**状态  1：可用  2：已分配  3：待维修*/
	private Integer status;
	
	/**被分配的办公室*/
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
