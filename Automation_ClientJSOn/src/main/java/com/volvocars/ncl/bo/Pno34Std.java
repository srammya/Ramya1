package com.volvocars.ncl.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tmohamed
 *
 */
public class Pno34Std {
	private String mainType;
	private String engine;
	private String salesVersion;
	private String sunRoof;
	private String transmission;
	private String lhdRhd;
	private String marketingCode;
	private String exteriorColourCode;
	private String interiorCode;
	private String option;
	private String smessage;
	private List optionsFeatureCodeList = new ArrayList();
	
	public String getMainType() {
		return mainType;
	}
	public void setMainType(String mainType) {
		this.mainType = mainType;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getSalesVersion() {
		return salesVersion;
	}
	public void setSalesVersion(String salesVersion) {
		this.salesVersion = salesVersion;
	}
	public String getSunRoof() {
		return sunRoof;
	}
	public void setSunRoof(String sunRoof) {
		if(sunRoof == null){
			this.sunRoof = "";
		}else {
			this.sunRoof = sunRoof;
		}
		
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		if(transmission == null){
			this.transmission = "";
		}else {
			this.transmission = transmission;
		}
		
	}
	public String getLhdRhd() {
		return lhdRhd;
	}
	public void setLhdRhd(String lhdRhd) {
		if(lhdRhd == null){
			this.lhdRhd = "";
		}else {
			this.lhdRhd = lhdRhd;
		}
		
	}
	public String getMarketingCode() {
		return marketingCode;
	}
	public void setMarketingCode(String marketingCode) {
		if(marketingCode == null){
			this.marketingCode = "";
		}else {
			this.marketingCode = marketingCode;
		}
		
	}
	public String getExteriorColourCode() {
		return exteriorColourCode;
	}
	public void setExteriorColourCode(String exteriorColourCode) {
		if(exteriorColourCode == null){
			this.exteriorColourCode = "";
		}else {
			this.exteriorColourCode = exteriorColourCode;
		}
		
	}
	public String getInteriorCode() {
		return interiorCode;
	}
	public void setInteriorCode(String interiorCode) {
		if(interiorCode == null){
			this.interiorCode = "";
		}else {
			this.interiorCode = interiorCode;
		}
		
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		if(option == null){
			this.option = "";
		}else {
			this.option = option;
		}
		
	}
	public String getSmessage() {
		return smessage;
	}
	public void setSmessage(String smessage) {
		if(smessage == null){
			this.smessage = "";
		}else {
			this.smessage = smessage;
		}
		
	}
	
	/*@Override
    public String toString() {
        return "Pno34Std [mainType=" + mainType + ", engine=" + engine + ", salesVersion=" + salesVersion+ ", sunRoof=" + sunRoof + ", transmission=" + transmission + ", lhdRhd=" + lhdRhd+ ",marketingCode=" + marketingCode + ", exteriorColourCode=" + exteriorColourCode + ", interiorCode=" + interiorCode+ ", option=" + option + ", smessage=" + smessage + "]";
    }*/
	public List getOptionsFeatureCodeList() {
		return optionsFeatureCodeList;
	}
	public void setOptionsFeatureCodeList(List optionsFeatureCodeList) {
		this.optionsFeatureCodeList = optionsFeatureCodeList;
	}
	

}
