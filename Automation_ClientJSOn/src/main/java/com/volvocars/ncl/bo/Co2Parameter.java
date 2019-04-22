package com.volvocars.ncl.bo;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author tmohamed
 *
 */
@JsonRootName("Co2Parameters")
public class Co2Parameter {
	private String name;
	private String description;
	private String unit;
	private String Value;
	private String redaName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
	public String getRedaName() {
		return redaName;
	}
	public void setRedaName(String redaName) {
		this.redaName = redaName;
	}
	@Override
    public String toString() {
        return "[name=" + name + ", description=" + description + ",unit=" + unit + ",Value=" + Value + ", redaName=" + redaName+"]";
    }
}
