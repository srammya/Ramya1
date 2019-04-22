package com.volvocars.ncl.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author tmohamed
 *
 */
@JsonRootName(value="groups")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Groups {
	private List<GroupFeature> features = new ArrayList<GroupFeature>();
	private String id;
	private String name;
	private String position;
	
	public List<GroupFeature> getFeature() {
		return features;
	}
	@JsonProperty("features")
	public void setFeature(List<GroupFeature> groupFeature) {
		features = groupFeature;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
}
