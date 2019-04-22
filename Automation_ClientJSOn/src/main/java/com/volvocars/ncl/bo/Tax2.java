package com.volvocars.ncl.bo;

/**
 * @author tmohamed
 *
 */
public class Tax2 {
	private String name;
	private String Value;
	private String currency;
	private String price;
	private String pricewoVAT;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPricewoVAT() {
		return pricewoVAT;
	}
	public void setPricewoVAT(String pricewoVAT) {
		this.pricewoVAT = pricewoVAT;
	}
	@Override
    public String toString() {
        return "[name=" + name + ",Value=" + Value + "]";
    }
}
