package com.volvocars.ncl.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author tmohamed
 *
 */

@JsonRootName("features")
public class Features {
	
	
	private List<FeaturesList> featuresList = new ArrayList<FeaturesList>();

	/**
	 * @return the featuresList
	 */
	public List<FeaturesList> getFeaturesList() {
		return featuresList;
	}

	/**
	 * @param featuresList
	 *            the featuresList to set
	 */
	public void setFeaturesList(List<FeaturesList> featuresList) {
		this.featuresList = featuresList;
	}
}
