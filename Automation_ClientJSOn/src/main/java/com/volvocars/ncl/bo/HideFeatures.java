package com.volvocars.ncl.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author tmohamed
 *
 */
@JsonRootName("hideFeatures")
public class HideFeatures {
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeatureCode() {
		return featureCode;
	}
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "HideFeatures [type=" + type + ", name=" + name + ", featureCode=" + featureCode + ", position="
				+ position + "]";
	}
	
}
