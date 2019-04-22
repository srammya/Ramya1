package com.volvocars.ncl.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volvocars.ncl.action.NCLAutomateTest;
import com.volvocars.ncl.model.Feature;


 
/**
 * @author tmohamed
 *
 */
public class CarList {
 
    public static void main(String args[]){
         
        /**
         * Read object from file
         */
        CarFleet value = null;
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            value = mapper.readValue(new File("JSON_GB.json"), CarFleet.class);
            
            if(value != null) {
            	System.out.println(value.getCars().size());
            	
            	if(value.getCars() != null && value.getCars().size() != 0){
	            	for(int i = 0; i <value.getCars().size(); i++){
	            		System.out.println(value.getCars().get(i));
	            		Car car = value.getCars().get(i);
	            		if(car != null) {
	            			NCLAutomateTest.init();
	            			NCLAutomateTest.insertCars(car);
	            			NCLAutomateTest.end();
	            		}            	
	            	}    
            	}
           
           Map<String,FeaturesList> featureMap=null;
            for (Map.Entry<String, Object> feature : value.getFeatures().entrySet()) {
            	featureMap=new HashMap<>();
            	//FeatureCode fea=mapper.readValue(mapper.writeValueAsString(feature.getValue()),FeatureCode.class );
            	Map<String,Object> fea =mapper.readValue(mapper.writeValueAsString(feature.getValue()), HashMap.class);
            	for (Map.Entry<String, Object> featureCode : fea.entrySet()) {
            		FeaturesList feat=mapper.readValue(mapper.writeValueAsString(featureCode.getValue()),FeaturesList.class );
            		
            		NCLAutomateTest.init();
        			NCLAutomateTest.insertFeatures(feat);
        			NCLAutomateTest.end();
            		
            		System.out.println(featureCode.getValue());
            	}
				System.out.println(fea);
			}
            
            
            for(Map.Entry<String, Object> featureTypeGroups : value.getFeatureTypeGroups().entrySet()){
            	FeatureTypeGroups typeGroups = mapper.readValue(mapper.writeValueAsString(featureTypeGroups.getValue()), FeatureTypeGroups.class);
            	
            	NCLAutomateTest.init();
    			NCLAutomateTest.insertCarsGroups(typeGroups);
    			NCLAutomateTest.end();
            	
            	
            	for (Groups group : typeGroups.getGroup()) {
					System.out.println("gname: "+group.getId());
					for (GroupFeature gFeature : group.getFeature()) {
						System.out.println("gfname: "+ gFeature.getFeatureCode());
						
						
					}
				}
            	
            	}
            	
            

            	
            	/*Map<String,Object> featureTypeGroups =mapper.readValue(mapper.writeValueAsString(featureTypeGroups.getValue()), HashMap.class);
             	for (Map.Entry<String, Object> featureCode : fea.entrySet()) {
             		FeaturesList feat=mapper.readValue(mapper.writeValueAsString(featureCode.getValue()),FeaturesList.class );
             		
             		System.out.println(featureCode.getValue());
             	}*/
            	if(value.getFeatureTypeGroups() != null && value.getFeatureTypeGroups().size() != 0){
            		for(int i = 0; i <value.getFeatureTypeGroups().size(); i++){
                		System.out.println(value.getFeatureTypeGroups().get(i));
                		
                			//featureTypeGroups groups = value.getFeatureTypeGroups()
                			
                		}
            		
            	}
                		
                		/*FeatureTypeGroups featuretypegroup = value.getFeatureTypeGroups().get(i);
                		if(featuretypegroup != null){
                			
                			NCLAutomateTest.init();
                			NCLAutomateTest.insertCarsGroups(featuretypegroup);
                			NCLAutomateTest.end();
                			
                		}*/
                		
                		         	
                	
            	//}
            	
            	 
            	if(value.getFeatureTypeGroups() != null && value.getFeatures().size() != 0){
            		for(int i = 0; i <value.getFeatures().size(); i++){
                		System.out.println(value.getFeatures().get(i));
                		/*Features features = value.getFeatures().get(i);
                		if(features != null){
                			
                			NCLAutomateTest.init();
                			NCLAutomateTest.insertFeatures(features);
                			NCLAutomateTest.end();
                			
                			
                		}*/
                		
                		         	
                	}
            		
            	}
            	
            	}	       
        } catch (Exception e) {
            System.out.println("Exception ---->"+e);
        }   
 
    }
    
    public void jsonToDB(String jsonData) {
    	   /**
         * Read object from file
         */
        CarFleet value = null;
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            value = mapper.readValue(new File("JSON_US.json"), CarFleet.class);
            if(value != null) {
            	System.out.println(value.getCars().size());
            	
            	if(value.getCars() != null && value.getCars().size() != 0){
	            	for(int i = 0; i <value.getCars().size(); i++){
	            		System.out.println(value.getCars().get(i));
	            		Car car = value.getCars().get(i);
	            		if(car != null) {
	            			NCLAutomateTest.init();
	            			NCLAutomateTest.insertCars(car);
	            			NCLAutomateTest.end();
	            		}            	
	            	}    
            	}
            	
            	if(value.getFeatureTypeGroups() != null && value.getFeatureTypeGroups().size() != 0){
            		for(int i = 0; i <value.getFeatureTypeGroups().size(); i++){
                		System.out.println(value.getFeatureTypeGroups().get(i));
                		/*FeatureTypeGroups featuretypegroup = value.getFeatureTypeGroups().get(i);
                		if(featuretypegroup != null){
                			
                			NCLAutomateTest.init();
                			NCLAutomateTest.insertCarsGroups(featuretypegroup);
                			NCLAutomateTest.end();
                			
                		}*/
                		
                		         	
                	}
            	}
            	
            	if(value.getFeatureTypeGroups() != null && value.getFeatures().size() != 0){
            		for(int i = 0; i <value.getFeatures().size(); i++){
                		System.out.println(value.getFeatures().get(i));
                		/*Features features = value.getFeatures().get(i);
                		if(features != null){
                			
                			NCLAutomateTest.init();
                			NCLAutomateTest.insertFeatures(features);
                			NCLAutomateTest.end();
                			
                			
                		}*/
                		
                		         	
                	}
            	}
            	
            }
        
        } catch (Exception e) {
            System.out.println("Exception ---->"+e);
        }  
    }
    
	
}