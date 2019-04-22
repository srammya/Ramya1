package com.volvocars.ncl.bo;

/**
 * @author tmohamed
 *
 */
public class RetailPriceBeforeTax {
	private String name;
	private String Value;
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
	@Override
    public String toString() {
        return "[name=" + name + ",Value=" + Value + "]";
    }
	
}
