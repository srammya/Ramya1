package com.volvocars.ncl.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
 
/**
 * @author tmohamed
 *
 */
public class CarFleet {
	
	private String Locale;
    private List<Car> cars = new ArrayList<Car>();
    //@JsonIgnore
    
    private Map<String,Object> features = new HashMap<>();
  // private Map<List<Features>, List<FeaturesList>> features = new HashMap<List<Features>, List<FeaturesList>>();
  //  @JsonProperty("featureTypeGroups")
    private Map<String,Object> featureTypeGroups = new HashMap<>();
   // private List<FeatureTypeGroups> featureTypeGroups =  new ArrayList<>();
    //private List<Object> Error = null ;
    private String liveUpdateStatus;
    
    
    @JsonProperty
    public String getLocale() {
		return Locale;
	}
	public void setLocale(String locale) {
		Locale = locale;
	}
    public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}	
	
	
	/**
	 * @return the featureTypeGroups
	 */
	public Map<String, Object> getFeatureTypeGroups() {
		return featureTypeGroups;
	}
	/**
	 * @param featureTypeGroups the featureTypeGroups to set
	 */
	public void setFeatureTypeGroups(Map<String, Object> featureTypeGroups) {
		this.featureTypeGroups = featureTypeGroups;
	}
	
	
	
	/*public List<FeatureTypeGroups> getFeatureTypeGroups() {
		return featureTypeGroups;
	}
	public void setFeatureTypeGroups(List<FeatureTypeGroups> featureTypeGroups) {
		this.featureTypeGroups = featureTypeGroups;
	}*/
	@JsonProperty
	/*public List<Object> getError() {
		return Error;
	}
	public void setError(List<Object> error) {
		Error = error;
	}*/
		
	
	 @Override
	    public String toString() {
	        return "CarFleet [cars=" + cars + "]";
	    }
	
	public Map<String, Object> getFeatures() {
		return features;
	}
	
	public void setFeatures(Map<String, Object> features) {
		this.features = features;
	}
	public String getLiveUpdateStatus() {
		return liveUpdateStatus;
	}
	public void setLiveUpdateStatus(String liveUpdateStatus) {
		this.liveUpdateStatus = liveUpdateStatus;
	}
	
	
	/**
	 * @return the features
	 */
	/*public List<Features> getFeatures() {
		return features;
	}
	*//**
	 * @param features the features to set
	 *//*
	@JsonProperty("features")
	public void setFeatures(List<Features> features) {
		this.features = features;
	}*/
}