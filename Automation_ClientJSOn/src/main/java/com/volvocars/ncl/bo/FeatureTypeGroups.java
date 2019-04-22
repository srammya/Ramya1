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
@JsonRootName(value="featureTypeGroups")
@JsonIgnoreProperties(ignoreUnknown=true)
public class FeatureTypeGroups {
	 //private List<GroupFeature> groupFeature = new ArrayList<GroupFeature>();
	 
	 private String type;
	 private String name;
	 private String position;
	 private List<Groups> groups = new ArrayList<Groups>();
	 
	/*public List<GroupFeature> getFeature() {
		return groupFeature;
	}
	public void setFeature(List<GroupFeature> groupfeature) {
		groupFeature = groupfeature;
	}*/
	
	public List<Groups> getGroup() {
		return groups;
	}
	@JsonProperty("groups")
	public void setGroup(List<Groups> groups) {
		this.groups = groups;
	}
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
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
    public String toString() {
        return "[ Groups=" + groups + ", type=" + type + ", name=" + name + " Position=" + position + "]";
    }
	
}
