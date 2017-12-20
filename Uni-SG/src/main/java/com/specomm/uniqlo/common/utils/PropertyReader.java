package com.specomm.uniqlo.common.utils;

import org.testng.internal.PropertiesFile;


public class PropertyReader {
	public  String filename;
	
	
	public PropertyReader(String filename){
	this.filename=filename;
	}
	
	
	
	public String readProp(String key){
		try{
		PropertiesFile pf= new PropertiesFile(filename);
			
		return pf.getProperties().getProperty(key);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}