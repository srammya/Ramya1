package com.volvocars.ncl.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author tmohamed
 *
 */
@JsonRootName("nedcRrcx")
public class NedcRrcx {
	
	private List<Co2Parameter> Co2Parameter = new ArrayList<Co2Parameter>();

	public List<Co2Parameter> getCo2Parameter() {
		return Co2Parameter;
	}

	@JsonProperty("Co2Parameters")
	public void setCo2Parameter(List<Co2Parameter> co2Parameter) {
		Co2Parameter = co2Parameter;
	}
	@Override
    public String toString() {
        return "[Co2Parameter=" + Co2Parameter + "]";
    }
}
