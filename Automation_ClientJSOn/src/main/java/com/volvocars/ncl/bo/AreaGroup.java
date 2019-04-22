package com.volvocars.ncl.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author tmohamed
 *
 */
public class AreaGroup {
	private String id;
	private String name;
	private String value;
	public String getId() {
		return id;
	}
	@JsonProperty("areaGroupId")
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@JsonProperty("areaGroupName")
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
    public String toString() {
        return "[Id=" + id + ",Name=" + name + ", Value=" + value + "]";
    }
}
