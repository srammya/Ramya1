package com.volvocars.ncl.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TotalVATAmount {
	
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
        return "[name=" + name + ", Value=" + Value + "]";
    }
	
}


