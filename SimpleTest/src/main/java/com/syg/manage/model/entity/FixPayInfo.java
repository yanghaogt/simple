package com.syg.manage.model.entity;
/**
 * 计费点信息
 * @author Lao
 *
 */
public class FixPayInfo {
	private String diyId;
	private Double price;
	private String productCode;

	public String getDiyId() {
		return diyId;
	}

	public void setDiyId(String diyId) {
		this.diyId = diyId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString() {
		return "FixPayInfo [diyId=" + diyId + ", price=" + price
				+ ", productCode=" + productCode + "]";
	}
	
}
