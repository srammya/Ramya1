package com.volvocars.ncl.bo;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author tmohamed
 *
 */
@JsonRootName(value="feature")
public class GroupFeature {
	private String type;
	private String name;
	private String featureCode;
	private String position;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFeatureCode() {
		return featureCode;
	}
	
	public void setFeatureCode(String featurecode) {
		this.featureCode = featurecode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
    public String toString() {
        return "[type=" + type + ",Name=" + name + ", Position=" + position + ",FeatureCode=" + featureCode +"]";
    }
}
