package com.volvocars.ncl.bo;

/**
 * @author tmohamed
 *
 */
public class Name {
	private String modelYear;
	private String Value;
	
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	@Override
    public String toString() {
        return "[modelYear=" + modelYear + ", Value=" + Value + "]";
    }
}
