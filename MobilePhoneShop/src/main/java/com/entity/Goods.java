package com.entity;

public class Goods {
	private Integer goodsId;
	private String goodsContent;
	private Double goodsPrice;
	private String goodsPhoto;

	public Integer getGoods_id() {
		return goodsId;
	}

	public void setGoods_id(Integer goods_id) {
		this.goodsId = goods_id;
	}

	public String getGoodsContent() {
		return goodsContent;
	}

	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsPhoto() {
		return goodsPhoto;
	}

	public void setGoodsPhoto(String goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}

	@Override
	public String toString() {
		return "Goods [goods_id=" + goodsId + ", goodsContent=" + goodsContent + ", goodsPrice=" + goodsPrice
				+ ", goodsPhoto=" + goodsPhoto + "]";
	}
}
