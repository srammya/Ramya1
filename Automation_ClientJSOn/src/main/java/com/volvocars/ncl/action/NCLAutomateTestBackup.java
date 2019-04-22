/*package com.volvocars.ncl.action;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.volvocars.ncl.bo.GroupFeature;
import com.volvocars.ncl.bo.Features;
import com.volvocars.ncl.bo.HideFeatures;
import com.volvocars.ncl.bo.Pno34Std;

public class NCLAutomateTestBackup {
	private static EntityManager em;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		try{
	        emf = Persistence.createEntityManagerFactory("NCLDB");
			em = emf.createEntityManager();			
			Car car = createNCLAutomationPriceFinal();
			if(car != null){
				insertDealerInfos(car.getFyon());
				insertDrivelines(car.getFyon());
				insertHiddenPackages(car.getFyon());
				insertOptionsFeatureCode(car.getFyon());
				insertPackage(car.getFyon());
				insertPrice(car.getFyon());
			}
			nativeQuery(em, "Select * from Automation.FEATURES");
			//deleteRecords();
			em.close();
			emf.close();
		}catch(Exception e){
			throw e;
		}
	}
	
	public static void init() {
		try{
	        emf = Persistence.createEntityManagerFactory("NCLDB");
			em = emf.createEntityManager();		
		}catch(Exception e){
			
		}
	}
	public static void end() {
		try{
			em.close();
			emf.close();
		}catch(Exception e){
			throw e;
		}
	}
	
	public static void insertCars(com.volvocars.ncl.bo.Car car) {
		try{
			Pno34Std pno34Std = validatePno34Std(car.getPno34());
			car.setPno34Std(pno34Std);
			com.volvocars.ncl.model.Car  carModel= insertCar(car);
			if(car != null){
				insertDealerInfos(carModel.getFyon(),car);
				insertDrivelines(carModel.getFyon(),car);
				insertHiddenPackages(carModel.getFyon(),car);
				insertOptionsFeatureCode(carModel.getFyon(),car);
				insertPackage(carModel.getFyon(),car);
				insertPrice(carModel.getFyon(),car);
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public static void insertCarsGroups(com.volvocars.ncl.bo.Groups group) {
		try{
			insertCarGroups(group);
		}catch(Exception e){
			
		}
	}
	
	
	
		
	public static void nativeQuery(EntityManager em, String s) {
	      System.out.printf("'%s'%n", s);
	      Query query = em.createNativeQuery(s);
	      List list = query.getResultList();
	      for (Object o : list) {
	          if (o instanceof Object[]) {
	              System.out.println(Arrays.toString((Object[]) o));
	          } else {
	              System.out.println(o);
	          }
	      }
	      
	  }
	
	
	private static  com.volvocars.ncl.model.Car insertCar(com.volvocars.ncl.bo.Car car ) {
		com.volvocars.ncl.model.Car carModel = null;
		try {
			if(car != null){
				em.getTransaction().begin();
				carModel = new com.volvocars.ncl.model.Car();
				carModel.setFyon(Integer.parseInt(car.getFyon()));
				carModel.setModel_Year(Integer.parseInt(car.getModelYear()));
				carModel.setPno34(car.getPno34());
				carModel.setModel(car.getPno34Std().getMainType());
				carModel.setEngine(car.getPno34Std().getEngine());
				carModel.setSalesVersion(car.getPno34Std().getSalesVersion());
				carModel.setSunRoof(car.getPno34Std().getSunRoof());
				carModel.setGearBox(car.getPno34Std().getTransmission());
				carModel.setSteering(car.getPno34Std().getLhdRhd());
				carModel.setMarketingCode(car.getPno34Std().getMarketingCode());
				carModel.setColor(Integer.parseInt(car.getPno34Std().getExteriorColourCode()));
				carModel.setUpholstery(car.getPno34Std().getInteriorCode());
				carModel.setOptions(car.getPno34Std().getOption());
				carModel.setSMessage(car.getPno34Std().getSmessage());
				carModel.setVin(car.getVin());
				carModel.setRegistration_Number(car.getRegistrationNumber());
				carModel.setStructure_Week(car.getStructureWeek());
				carModel.setPartner(car.getdealerSiteCode());
				carModel.setDelivery_Date(car.getDeliveryDate());
				carModel.setDestination_Code(car.getDestinationCode());
				carModel.setIntermediate_Destination_Code(car.getIntermediateDestinationCode());
				carModel.setCommon_Status_Point(car.getCommonStatusPoint());
				carModel.setPrice_Date(car.getPriceDate());
				carModel.setPrice_List(car.getPriceList());
				carModel.setModel_Name(car.getName());
				carModel.setDistance_KM(car.getDistanceKm());
				carModel.setNoSpecAvailable(car.getNoSpecAvailable());
				carModel.setLdoc(car.getLdoc());
				carModel.setBrand_Order_Type(car.getBrandOrderType());
				carModel.setOrder_Number(car.getOrderNumber());
				carModel.setOwnership(car.getOwnership());
				carModel.setTrade_Type(car.getTradeType());
				carModel.setIsNSCStockCar(car.getIsNscStockCar());
				carModel.setAccessories(car.getAccessories());
				carModel.setDealerFittedAccessories(car.getDealerFittedAccessories());
				carModel.setCommercialModelYear(car.getCommercialModelYear());
				carModel.setTaxCalcBasedOn(car.getTaxCalcBasedOn());	
				carModel.setIsWLTP(car.getIsWLTP());
				carModel.setIsURAX(car.getIsURAX());
				carModel.setNedcRrcx("");
				carModel.setWltpi(car.getWLTPI());
				em.persist(carModel);		
				em.getTransaction().commit();	
			}
		}catch(Exception e){
			em.close();
			System.out.println(e.getLocalizedMessage());
		}
		
		System.out.println("<----------------------------HappyDay----------------------->");
		return carModel;
				
		
	}
	
	public static Pno34Std validatePno34Std(String pno34) {
    	Pno34Std pno34Std = null;
    	try {
    		if(pno34 != null && pno34.length() >= 34) {
    			System.out.println("Total Size --->"+pno34.length());
    			pno34Std = new Pno34Std();
    			String mainType = pno34.substring(0, 3);
    			pno34Std.setMainType(mainType);
    			String engine = pno34.substring(3, 5);
    			pno34Std.setEngine(engine);
    			String salesVersion = pno34.substring(5, 7);
    			pno34Std.setSalesVersion(salesVersion);
    			String sunRoof = pno34.substring(7, 8);
    			pno34Std.setSunRoof(sunRoof);
    			String transmission = pno34.substring(8, 9);
    			pno34Std.setTransmission(transmission);
    			String lhdRhd = pno34.substring(9, 10);
    			pno34Std.setLhdRhd(lhdRhd);
    			String marketingCode = pno34.substring(10, 12);
    			pno34Std.setMarketingCode(marketingCode);
    			String exteriorColourCode = pno34.substring(12, 17);
    			pno34Std.setExteriorColourCode(exteriorColourCode);
    			String interiorCode = pno34.substring(17, 23);
    			pno34Std.setInteriorCode(interiorCode);
    			String option = pno34.substring(23, 29);
    			pno34Std.setOption(option);
    			String smessage = pno34.substring(29, 34);
    			pno34Std.setSmessage(smessage);
    			System.out.println(pno34Std.getSmessage());
    				    			
    			String hideFeature = pno34.substring(34, pno34.length());
    			int firstPos = 0;	    			
    			List hideFeatureList = new ArrayList();
    			for(int i=0;i<=hideFeature.length();i+=6){
    				
    				//System.out.println("i------>"+i);
    				//System.out.println("firstPos --->"+firstPos);
    				//System.out.println("vlaue---->"+hideFeature.substring(firstPos, i));
    				if(i!=0)
    				hideFeatureList.add(hideFeature.substring(firstPos, i));
    				firstPos = i;
    				
    			}
    			pno34Std.setOptionsFeatureCodeList(hideFeatureList);
    			//System.out.println("List size---->"+hideFeatureList.size());
    			for(int i=0;i<=hideFeatureList.size();i++){
    				System.out.println("List Data---->"+hideFeatureList.get(i));
    			}	    	
    			
    		} 
    	}catch(Exception e){
    		throw e;
    	}
		return pno34Std;
    	
    }
	
	private static void insertDealerInfos(int  fyon,com.volvocars.ncl.bo.Car car) {
		try{	
			if(car != null){				
				em.getTransaction().begin(); 		
				com.volvocars.ncl.model.Car carDealerInfo =em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.DealerInfo dealerInfo = new com.volvocars.ncl.model.DealerInfo();
				dealerInfo.setCar(carDealerInfo);
				if(car.getAreaGroup().getId() == null){
					dealerInfo.setArea_Group_Id("");
				}else{
					dealerInfo.setArea_Group_Id(car.getAreaGroup().getId());	
				}
				if(car.getdealerSiteCode() == null){
					dealerInfo.setDealer_Code("");	
				}else {
					dealerInfo.setDealer_Code(car.getdealerSiteCode());	
				}
				
				if(car.getCommercialGroup() == null || car.getCommercialGroup().getPartnerGroupId() == null ){
					dealerInfo.setPartner_Group_Id("");	
				}else{
					dealerInfo.setPartner_Group_Id(car.getCommercialGroup().getPartnerGroupId());		
				}
				em.persist(dealerInfo);		
				em.getTransaction().commit();
			}
			System.out.println("<-----------------End insertDealerInfos----------------------->");
		}catch(Exception e) {
			em.close();
			System.out.println("insertDealerInfos		--->"+e);
			throw e;
		}
	}
	
	private static void insertDrivelines(int  fyon,com.volvocars.ncl.bo.Car car) {
		try{
			if(car != null){
				em.getTransaction().begin(); 		
				com.volvocars.ncl.model.Car carDrivelines =em.find(com.volvocars.ncl.model.Car.class, fyon);		
				com.volvocars.ncl.model.Driveline driveline = new com.volvocars.ncl.model.Driveline();	
				driveline.setCar(carDrivelines);
				if(car.getDriveline() == null){
					driveline.setDriveLine_Id("");
				}else{
					driveline.setDriveLine_Id(car.getDriveline());	
				}
				em.persist(driveline);		
				em.getTransaction().commit();	
			}
			System.out.println("<-----------------End insertDrivelines----------------------->");
		}catch(Exception e){
			em.close();
			System.out.println("insertDrivelines		--->"+e.getMessage());
			throw e;
		}
	}
	
	private static void insertHiddenPackages(int  fyon,com.volvocars.ncl.bo.Car car) {
		try{
			if(car != null){
				com.volvocars.ncl.model.Car carHiddenPackages =em.find(com.volvocars.ncl.model.Car.class, fyon);		
				if(car.getHideFeatures()!= null && car.getHideFeatures().size()!=0){
					em.getTransaction().begin();
					for(int j=0; j<car.getHideFeatures().size();j++){
						HideFeatures hideFeatures = car.getHideFeatures().get(j);
						List<GroupFeature> featureList = hideFeatures.getFeature();
						if(featureList!= null && featureList.size()!=0){							
							for(int i=0; i < featureList.size();i++){
								GroupFeature groupFeature = featureList.get(i);
								com.volvocars.ncl.model.HiddenPackage hiddenPackage = new com.volvocars.ncl.model.HiddenPackage();
								hiddenPackage.setCar(carHiddenPackages);
								if(groupFeature.getCode() == null){
									hiddenPackage.setFeature_Code("");
								}else{
									hiddenPackage.setFeature_Code(groupFeature.getCode());	
								}
								em.persist(hiddenPackage);
							}
							
						}
					}
					//hiddenPackage.setFeature_Code(car.getf);					
					em.getTransaction().commit();
				}
			}
			System.out.println("<-----------------End insertHiddenPackages----------------------->");
		}catch(Exception e){
			em.close();
			System.out.println("insertHiddenPackages		--->"+e.getMessage());
			throw e;
		}
	}
	
	private static void insertOptionsFeatureCode(int  fyon,com.volvocars.ncl.bo.Car car) {	
		try{
			if(car != null){
				List optionsFeatureCodeList = car.getPno34Std().getOptionsFeatureCodeList();
				if(optionsFeatureCodeList.size()!= 0 && optionsFeatureCodeList != null){
					em.getTransaction().begin(); 
					com.volvocars.ncl.model.Car carOptionsFeatureCode =em.find(com.volvocars.ncl.model.Car.class, fyon);					
					for(int i=0;i<optionsFeatureCodeList.size();i++) {
						String optionsFeature = (String) optionsFeatureCodeList.get(i);							
						com.volvocars.ncl.model.OptionsFeatureCode optionsFeatureCode = new com.volvocars.ncl.model.OptionsFeatureCode();
						optionsFeatureCode.setCar(carOptionsFeatureCode);
						optionsFeatureCode.setOption_Feature_Code(optionsFeature);
						em.persist(optionsFeatureCode);	
						
					}																
					em.getTransaction().commit();
				}
			}
			System.out.println("<-----------------End insertOptionsFeatureCode----------------------->");
		}catch(Exception e){
			System.out.println("insertOptionsFeatureCode		--->"+e.getMessage());
			throw e;
		}finally {
	          em.close();
	          emf.close();
	     }
	}
	
	private static void insertPackage(int  fyon,com.volvocars.ncl.bo.Car car) {	
		try{
			com.volvocars.ncl.model.CarPackage carPackage = null;
			if(car != null){
				if(car.getPackage() != null || car.getPackage().size() != 0) {
					com.volvocars.ncl.model.Car carPackageFyon =em.find(com.volvocars.ncl.model.Car.class, fyon);	
					if(car.getPackage() != null ){
						List<com.volvocars.ncl.bo.Package> packageList = car.getPackage();
						if(packageList != null || packageList.size() != 0){
							em.getTransaction().begin();
							for(int i=0; i< packageList.size();i++) {		
								com.volvocars.ncl.bo.Package carPack = packageList.get(i);
								if(carPack != null){
									List<GroupFeature> featureList = carPack.getFeature();
									if(featureList != null || featureList.size() != 0){
										for(int j=0;j<featureList.size();j++){
											GroupFeature groupFeature = featureList.get(j);
											carPackage = new com.volvocars.ncl.model.CarPackage();
											carPackage.setCar(carPackageFyon);	
											if(carPack.getCode() == null){
												carPackage.setPackage_Code("");
											}else{
												carPackage.setPackage_Code(carPack.getCode());	
											}
											if(groupFeature.getCode() == null){
												carPackage.setFeature_Code("");
											}else{
												carPackage.setFeature_Code(groupFeature.getCode());	
											}
											em.persist(carPackage);	
										}
									}
								}
							}
						}	
						em.getTransaction().commit();
					}
				}
			}
			System.out.println("<-----------------End insertPackage----------------------->");
		}catch(Exception e){
			 em.close();
			System.out.println("insertPackage		--->"+e.getMessage());
			throw e;
		}
	}
	
	private static void insertPrice(int  fyon,com.volvocars.ncl.bo.Car car) {	
		try{
			if(car != null){
				em.getTransaction().begin(); 		
				com.volvocars.ncl.model.Car carPrice =em.find(com.volvocars.ncl.model.Car.class, fyon);		
				com.volvocars.ncl.model.Price price = new com.volvocars.ncl.model.Price();
				price.setCar(carPrice);
				if(car.getPrice() != null){
					if(car.getPrice().getCurrency() == null){
						price.setCurrency("");
					}else{
						price.setCurrency(car.getPrice().getCurrency());	
					}																									
					if(car.getPrice().getBasicPrice() == null  || car.getPrice().getBasicPrice().getName() == null){
						price.setBasic_Price_Name("");
					}else{
						price.setBasic_Price_Name(car.getPrice().getBasicPrice().getName());	
					}
					if( car.getPrice().getBasicPrice() == null  ||car.getPrice().getBasicPrice().getValue() == null){
						price.setBasic_Price_Value("");
					}else{
						price.setBasic_Price_Value(car.getPrice().getBasicPrice().getValue());	
					}
					if(car.getPrice().getDeliveryCharge() == null || car.getPrice().getDeliveryCharge().getName() == null){
						price.setDelivery_Charge_Name("");
					}else{
						price.setDelivery_Charge_Name(car.getPrice().getDeliveryCharge().getName());	
					}
					if(car.getPrice().getDeliveryCharge() == null || car.getPrice().getDeliveryCharge().getValue() == null){
						price.setDelivery_Charge_Value("");
					}else{
						price.setDelivery_Charge_Value(car.getPrice().getDeliveryCharge().getValue());	
					}
					if(car.getPrice().getRetailPriceBeforeTax() == null || car.getPrice().getRetailPriceBeforeTax().getName() == null ){
						price.setRetail_Price_Before_Tax_Name("");
					}else{
						price.setRetail_Price_Before_Tax_Name(car.getPrice().getRetailPriceBeforeTax().getName());	
					}
					if(car.getPrice().getRetailPriceBeforeTax() == null || car.getPrice().getRetailPriceBeforeTax().getValue() == null){
						price.setRetail_Price_Before_Tax_Value("");
					}else{
						price.setRetail_Price_Before_Tax_Value(car.getPrice().getRetailPriceBeforeTax().getValue());	
					}
					if(car.getPrice().getTax1() == null || car.getPrice().getTax1().getName() == null ){
						price.setTax1_Name("");
					}else{
						price.setTax1_Name(car.getPrice().getTax1().getName());
					}
					if(car.getPrice().getTax1() == null || car.getPrice().getTax1().getValue() == null ) {
						price.setTax1_Value("");
					}else{
						price.setTax1_Value(car.getPrice().getTax1().getValue());	
					}
					
					if(car.getPrice().getTax2() == null || car.getPrice().getTax2().getName() == null ){
						price.setTax2_Name("");
					}else{
						price.setTax2_Name(car.getPrice().getTax2().getName());
					}
					if(car.getPrice().getTax2() == null || car.getPrice().getTax2().getValue() == null ) {
						price.setTax2_Value("");
					}else{
						price.setTax2_Value(car.getPrice().getTax2().getValue());	
					}
					
					if(car.getPrice().getTax3() == null || car.getPrice().getTax3().getName() == null ){
						price.setTax3_Name("");
					}else{
						price.setTax3_Name(car.getPrice().getTax3().getName());
					}
					if(car.getPrice().getTax3() == null || car.getPrice().getTax3().getValue() == null ) {
						price.setTax3_Value("");
					}else{
						price.setTax3_Value(car.getPrice().getTax3().getValue());	
					}
					
					if(car.getPrice().getTax4() == null || car.getPrice().getTax4().getName() == null ){
						price.setTax4_Name("");
					}else{
						price.setTax4_Name(car.getPrice().getTax4().getName());
					}
					if(car.getPrice().getTax4() == null || car.getPrice().getTax4().getValue() == null ) {
						price.setTax4_Value("");
					}else{
						price.setTax4_Value(car.getPrice().getTax4().getValue());	
					}
					
					if(car.getPrice().getTotalPrice()== null || car.getPrice().getTotalPrice().getName() == null ){
						price.setTotal_Price_Name("");	
					}else{
						price.setTotal_Price_Name(car.getPrice().getTotalPrice().getName());
					}
					
					if(car.getPrice().getTotalPrice()== null || car.getPrice().getTotalPrice().getValue() == null){
						price.setTotal_Price_Value("");
					}else{
						price.setTotal_Price_Value(car.getPrice().getTotalPrice().getValue());	
					}
					
					if(car.getPrice() == null || car.getPrice().getTotalTaxAmount() == null){
						price.setTotal_Tax_Amount("");
					}else{
						price.setTotal_Tax_Amount(car.getPrice().getTotalTaxAmount());	
					}
					
					price.setUrax_Taxes("");	
					em.persist(price);		
					em.getTransaction().commit();	
				}
			}
			System.out.println("<-----------------End insertPrice----------------------->");
		}catch(Exception e){
			em.close();
			System.out.println("insertPrice		--->"+e.getMessage());
			throw e;
		}
	}
	
	
	
	
	public static void insertCarGroups(com.volvocars.ncl.bo.Groups group) {	
		String type;
		String name;
		com.volvocars.ncl.model.CarGroup groupModel;
		try{
			if(group != null){
				
				em.getTransaction().begin();
				
				 type = group.getType();
				 name = group.getName();
				
				List<GroupFeature> featureList = group.getFeature();
				if(featureList != null && featureList.size() != 0){
					 for(int i=0;i<featureList.size();i++){
						 GroupFeature groupFeature = featureList.get(i);	
						 
						  groupModel = new com.volvocars.ncl.model.CarGroup();
						 groupModel.setSub_Group_Name("Test");
						 groupModel.setSub_Group_Type_Id(0);
						 if(type == null){
								groupModel.setGroup_Id(Integer.parseInt(""));		
						 }else{
								groupModel.setGroup_Id(Integer.parseInt(type));	
						 }
						 if(name == null){
								groupModel.setGroup_Name("");
						 }else{
								groupModel.setGroup_Name(name);
						 }						
						 
	
						 if(groupFeature.getCode() == null){
							 groupModel.setFeature_Code("");
						 }else{
							 groupModel.setFeature_Code(groupFeature.getCode());	 
						 }
						 
						 if(name == null){
							 groupModel.setGroup_Id(Integer.parseInt(""));	
						 }else {
							 groupModel.setGroup_Id(Integer.parseInt(groupFeature.getType()));	
						 }
						
						em.persist(groupModel);					 					 
					 }				 				
				 }
				
				 List<com.volvocars.ncl.bo.Groups> groupList = group.getGroup();
				 if(groupList != null && groupList.size() != 0){
					 for(int i=0;i<groupList.size();i++){
						 com.volvocars.ncl.bo.Groups groupBO = groupList.get(i);	
						 
						 List<GroupFeature> featureBoList = groupBO.getFeature();
						 if(featureBoList != null && featureBoList.size() != 0){
							 for(int j=0;j<featureBoList.size();j++){
								 GroupFeature groupFeature = featureBoList.get(j);	
								 groupModel = new com.volvocars.ncl.model.CarGroup();
								 
								 if(name == null){
										groupModel.setGroup_Name("");
								 }else{
										groupModel.setGroup_Name(name);
								 }	
								 if(groupBO.getType() == null){
										groupModel.setSub_Group_Type_Id(Integer.parseInt(""));		
								 }else{
										groupModel.setSub_Group_Type_Id(Integer.parseInt(groupBO.getType()));	
								 }
								 if(groupBO.getName() == null){
										groupModel.setSub_Group_Name("");
								 }else{
										groupModel.setSub_Group_Name( groupBO.getName());
								 }
								
								 if(groupFeature.getCode() == null){
									 groupModel.setFeature_Code("");
								 }else{
									 groupModel.setFeature_Code(groupFeature.getCode());	 
								 }
								 						 
								
								 if(groupFeature.getType() == null){
									 groupModel.setGroup_Id(Integer.parseInt(""));
								 }else{
									 groupModel.setGroup_Id(Integer.parseInt(groupFeature.getType()));	 
								 }
								 em.persist(groupModel);
							 }
							 
						 }
						
					 }
				 }
				 em.getTransaction().commit();
			}
			System.out.println("<-----------------End insertCarGroups----------------------->");
		}catch(Exception e){
			em.close();
			System.out.println("Error --->"+e.getMessage());
			throw e;
			
		}
			
	}

	public static void insertFeatures(Features features) {
		// TODO Auto-generated method stub
		com.volvocars.ncl.model.Feature feature;
		try{
			
			
			com.volvocars.ncl.model.TypeMaster typeMaster =em.find(com.volvocars.ncl.model.TypeMaster.class, Integer.parseInt(features.getType()));
			if(typeMaster != null){
				em.getTransaction().begin();
				feature = new com.volvocars.ncl.model.Feature();
				feature.setTypeMaster(typeMaster);
				if(features.getCode() == null) {
					feature.setFeature_Code("");	
				}else {
					feature.setFeature_Code(features.getCode());
				}
				if(features.getDescription() == null) {
					feature.setFeature_Description("");
				}else {
					feature.setFeature_Description(features.getDescription() );
				}
				if(features.getName() == null || features.getName().get(0).getModelYear() == null) {
					feature.setModel_Year(0000);
				}else {
					feature.setModel_Year(Integer.parseInt(features.getName().get(0).getModelYear()));
				}
				 em.persist(feature);
				 em.getTransaction().commit();
			}else{
				System.out.println("Type code is not available in TypeMaster");
			}
			System.out.println("<-----------------End insertFeatures----------------------->");
		}catch(Exception e){
			em.close();
			System.out.println("Error --->"+e.getMessage());
			throw e;
		}
	}
	
	public static void deleteRecords() {
		// TODO Auto-generated method stub
		try{
			em.getTransaction().begin();
		    Query featuresTable = em.createNativeQuery("DELETE FROM Automation.FEATURES");
		    Query carGroupTable = em.createNativeQuery("DELETE FROM Automation.CAR_GROUP");
		    Query priceTable = em.createNativeQuery("DELETE FROM Automation.PRICE");
		    Query carPackageTable = em.createNativeQuery("DELETE FROM Automation.CAR_PACKAGE");
		    Query featureCodeTable = em.createNativeQuery("DELETE FROM Automation.OPTIONS_FEATURE_CODE");
		    Query hiddenPackageTable = em.createNativeQuery("DELETE FROM Automation.HIDDEN_PACKAGE");
		    Query driveLineTable = em.createNativeQuery("DELETE FROM Automation.DRIVELINE");
		    Query dealerInfoTable = em.createNativeQuery("DELETE FROM Automation.DEALER_INFO");
		    Query carTable = em.createNativeQuery("DELETE FROM Automation.CARS");
		    
		    featuresTable.executeUpdate();
		    carGroupTable.executeUpdate();
		    priceTable.executeUpdate();
		    carPackageTable.executeUpdate();
		    featureCodeTable.executeUpdate();
		    hiddenPackageTable.executeUpdate();
		    driveLineTable.executeUpdate();
		    dealerInfoTable.executeUpdate();
		    carTable.executeUpdate();
		    
		    em.getTransaction().commit();
			System.out.println("<-----------------End deleteRecords----------------------->");
		}catch(Exception e){
			em.close();
			System.out.println("Error --->"+e.getMessage());
			throw e;
		}
	}
	
	
}
*/