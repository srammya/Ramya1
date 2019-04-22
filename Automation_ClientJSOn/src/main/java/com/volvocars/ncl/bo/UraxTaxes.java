package com.volvocars.ncl.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author tmohamed
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class UraxTaxes {
	private String vatPosition;
	private String taxid;
	private String taxVersion;
	private String name;
	private String Value;
	public String getVatPosition() {
		return vatPosition;
	}
	public void setVatPosition(String vatPosition) {
		this.vatPosition = vatPosition;
	}
	public String getTaxid() {
		return taxid;
	}
	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}
	public String getTaxVersion() {
		return taxVersion;
	}
	public void setTaxVersion(String taxVersion) {
		this.taxVersion = taxVersion;
	}
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
        return "[vatPosition=" + vatPosition + ", taxid=" + taxid + ", taxVersion=" + taxVersion+ ", name=" + name + ", Value=" + Value + "]";
    }
	
}
