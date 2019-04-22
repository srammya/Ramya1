package com.volvocars.ncl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.volvocars.ncl.bo.Co2Parameter;
import com.volvocars.ncl.bo.Features;
import com.volvocars.ncl.bo.FeaturesList;
import com.volvocars.ncl.bo.GroupFeature;
import com.volvocars.ncl.bo.Groups;
import com.volvocars.ncl.bo.HideFeatures;
import com.volvocars.ncl.bo.Name;
import com.volvocars.ncl.bo.NedcRrcx;
import com.volvocars.ncl.bo.Pno34Std;
import com.volvocars.ncl.bo.UraxTaxes;
import com.volvocars.ncl.bo.Variants;
import com.volvocars.ncl.bo.WLTP;
import com.volvocars.ncl.model.Feature;

public class NCLAutomateTest {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	protected static Properties config, prop;
	String sheetName = "Dealer_Home";
	public static HashMap<String, String> tdrow;

	public static void main(String[] args) {
		try {
			emf = Persistence.createEntityManagerFactory("NCLDB");
			em = emf.createEntityManager();
			/*
			 * Car car = createNCLAutomationPriceFinal(); if(car != null){
			 * insertDealerInfos(car.getFyon());
			 * insertDrivelines(car.getFyon());
			 * insertHiddenPackages(car.getFyon());
			 * insertOptionsFeatureCode(car.getFyon());
			 * insertPackage(car.getFyon()); insertPrice(car.getFyon()); }
			 */
			// nativeQuery(em, "Select * from Automation.FEATURES");
			deleteRecords();
			em.close();
			emf.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void init() {
		try {
			emf = Persistence.createEntityManagerFactory("NCLDB");
			em = emf.createEntityManager();
		} catch (Exception e) {
		}
	}

	public static void end() {
		try {
			em.close();
			emf.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void loadProp() {
		prop = new Properties();
		try {
			// prop.load(new FileInputStream(new File("./Object.properties")));
			prop.load(new FileInputStream(new File("./config.properties")));
		} catch (FileNotFoundException e) {
			System.err.println("'*.properties' multiple file load Error. Please check the file exist/name of the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("'*.properties' multiple file load Error. Please check the Input data of the file");
			e.printStackTrace();
		}
	}

	public static void insertCars(com.volvocars.ncl.bo.Car car) {
		try {
			Pno34Std pno34Std = validatePno34Std(car.getPno34());
			car.setPno34Std(pno34Std);
			com.volvocars.ncl.model.Car carModel = insertCar(car);
			if (car != null) {
				loadProp();
				insertDealerInfos(carModel.getFyon(), car);
				insertDealerDetails(carModel.getFyon(), car);
				insertDrivelines(carModel.getFyon(), car);
				insertHiddenPackages(carModel.getFyon(), car);
				insertOptionsFeatureCode(carModel.getFyon(), car);
				insertPackage(carModel.getFyon(), car);
				insertPrice(carModel.getFyon(), car);
				insertVariants(carModel.getFyon(), car);
				insertNedcRrcx(carModel.getFyon(), car);
				insertWltp(carModel.getFyon(), car);
				insertUraxTaxes(carModel.getFyon(), car);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static void insertCarsGroups(com.volvocars.ncl.bo.FeatureTypeGroups featuretypegroup) {
		try {
			insertCarFeatureTypeGroups(featuretypegroup);
		} catch (Exception e) {

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

	private static com.volvocars.ncl.model.Car insertCar(com.volvocars.ncl.bo.Car car) {
		com.volvocars.ncl.model.Car carModel = null;
		boolean identityInsertSetToOn = false;
		try {
			if (car != null) {
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
				carModel.setColor(car.getPno34Std().getExteriorColourCode());
				carModel.setUpholstery(car.getPno34Std().getInteriorCode());
				carModel.setOptions(car.getPno34Std().getOption());
				carModel.setSMessage(car.getPno34Std().getSmessage());
				carModel.setVin(car.getVin());
				carModel.setRegistration_Number(car.getRegistrationNumber());
				carModel.setStructure_Week(car.getStructureWeek());
				carModel.setPartner(car.getdealerSiteCode());
				carModel.setDelivery_Date(car.getDeliveryDate()==null ?"" : car.getDeliveryDate());
				carModel.setDestination_Code(car.getDestinationCode());
				carModel.setIntermediate_Destination_Code(car.getIntermediateDestinationCode()==null?"":car.getIntermediateDestinationCode());
				carModel.setCommon_Status_Point(car.getCommonStatusPoint());
				carModel.setPrice_Date(car.getPriceDate());
				carModel.setPrice_List(car.getPriceList());
				carModel.setModel_Name(car.getName());
				carModel.setDistance_KM(car.getDistance());
				carModel.setNoSpecAvailable(car.getNoSpecAvailable());
				carModel.setLdoc(car.getLdoc());
				carModel.setBrand_Order_Type(car.getOrderType());
				carModel.setOrder_Number(car.getCommonOrderNumber());
				carModel.setOwnership(car.getOwnership());
				carModel.setTrade_Type(car.getTradeType());
				carModel.setIsNSCStockCar(car.getIsNscStockCar());
				//carModel.setAccessories(car.getAccessories());
				carModel.setDealerFittedAccessories(car.getDealerFittedAccessories());
				carModel.setCommercialModelYear(car.getCommercialModelYear());
				carModel.setTaxCalcBasedOn(car.getTaxCalcBasedOn());
				carModel.setIsWLTP(car.getIsWLTP());
				carModel.setIsURAX(car.getIsURAX());
				carModel.setNedcRrcx("");
				carModel.setWltpi(car.getWLTPI());
				carModel.setVariant_Feature_Code("");
				carModel.setTaxCalcBasedOn(car.getTaxCalcBasedOn());
				carModel.setEfficiency_Class(car.getEfficiencyClass());
				//em.createNativeQuery("SET IDENTITY_INSERT dbo.cars ON");
				identityInsertSetToOn = true;
				//em.getTransaction().commit();
				//em.getTransaction().begin();
				em.persist(carModel);
			em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}finally {
	        if (identityInsertSetToOn) {
	          //  em.createNativeQuery("SET IDENTITY_INSERT dbo.cars OFF");
	        }
		}
		System.out.println("<----------------------------HappyDay----------------------->");
		return carModel;

	}

	public static Pno34Std validatePno34Std(String pno34) {
		Pno34Std pno34Std = null;
		try {
			if (pno34 != null && pno34.length() >= 34) {
				System.out.println("Total Size --->" + pno34.length());
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
				for (int i = 0; i <= hideFeature.length(); i += 6) {

					// System.out.println("i------>"+i);
					// System.out.println("firstPos --->"+firstPos);
					// System.out.println("vlaue---->"+hideFeature.substring(firstPos,
					// i));
					if (i != 0)
						hideFeatureList.add(hideFeature.substring(firstPos, i));
					firstPos = i;

				}
				pno34Std.setOptionsFeatureCodeList(hideFeatureList);
				// System.out.println("List size---->"+hideFeatureList.size());
				/*
				 * for(int i=0;i<=hideFeatureList.size();i++){
				 * System.out.println("List Data---->"+hideFeatureList.get(i));
				 * }
				 */

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return pno34Std;

	}

	private static void insertVariants(int fyon, com.volvocars.ncl.bo.Car car) {
		// String type;
		try {
			if (car != null) {
				
				com.volvocars.ncl.model.Car carVariants = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.Variant variantsModel;
				

				List<Variants> variantList = car.getVariants();
				if (variantList != null && variantList.size() != 0) {
					
					for (int i = 0; i < variantList.size(); i++) {
						em.getTransaction().begin();
						variantsModel = new com.volvocars.ncl.model.Variant();
						variantsModel.setCar(carVariants);
						Variants variant = variantList.get(i);
						if (variant.getType() == null) {
							variantsModel.setVariant_Type(Integer.parseInt(""));
						} else {
							variantsModel.setVariant_Type(Integer.parseInt(variant.getType()));
						}
						if (variant.getFeatureCode() == null) {
							variantsModel.setVariant_FeatureCode("");
						} else {
							variantsModel.setVariant_FeatureCode(variant.getFeatureCode());
						}
						if (variant.getName() == null) {
							variantsModel.setVariant_Name("");
						} else {
							variantsModel.setVariant_Name(variant.getName());
						}
						if (variant.getDescription() == null) {
							variantsModel.setVariant_Description("");
						} else {
							variantsModel.setVariant_Description(variant.getDescription());
						}
						if (variant.getModelYear() == null) {
							variantsModel.setVariant_ModelYear("");
						} else {
							variantsModel.setVariant_ModelYear(variant.getModelYear());
						}
						em.persist(variantsModel);
						em.getTransaction().commit();
					}
					
				}
				
				
			}
			System.out.println("<------*----------End insertVariantDetails--------------*-------->");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertVariantDetails		--->" + e);
			throw e;
		}
	}

	private static void insertDealerDetails(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			// ExcelUtils excelUtils = new ExcelUtils();
			// tdrow=excelUtils.testCaseRetrieve("JSON Dealer
			// fetch","Dealer_Home");
			String dealerCode = prop.getProperty("DealerCode");
			// String dealerCode = "6GB70548";
			if (car != null) {
				em.getTransaction().begin();
				com.volvocars.ncl.model.Car carDealerDetails = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.DealerDetail dealerDetail = new com.volvocars.ncl.model.DealerDetail();
				dealerDetail.setCar(carDealerDetails);
				if (dealerCode == null) {
					dealerDetail.setDealerCode("");
				} else {
					dealerDetail.setDealerCode(dealerCode);
				}
				if (car.getdealerSiteCode() == null) {
					dealerDetail.setPartnerID("");
				} else {
					dealerDetail.setPartnerID(car.getdealerSiteCode());
				}
				if (car.getOwnership() == null) {
					dealerDetail.setOwnership("");
				} else {
					dealerDetail.setOwnership(car.getOwnership());
				}
				em.persist(dealerDetail);
				em.getTransaction().commit();
			}
			System.out.println("<------*----------End insertDealerDetails--------------*-------->");
		} catch (Exception e) {
			System.out.println("insertDealerDetails		--->" + e);
			throw e;
		}
	}

	private static void insertDealerInfos(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null) {

				em.getTransaction().begin();
				com.volvocars.ncl.model.Car carDealerInfo = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.DealerInfo dealerInfo = new com.volvocars.ncl.model.DealerInfo();
				dealerInfo.setCar(carDealerInfo);
				if (car.getAreaGroup() == null) {
					dealerInfo.setArea_Group_Id("");
				} else if (car.getAreaGroup().getId() == null) {
					dealerInfo.setArea_Group_Id("");
				} else {
					dealerInfo.setArea_Group_Id(car.getAreaGroup().getId());
				}
				if (car.getdealerSiteCode() == null) {
					dealerInfo.setDealer_Code("");
				} else {
					dealerInfo.setDealer_Code(car.getdealerSiteCode());
				}

				if (car.getCommercialGroup() == null || car.getCommercialGroup().getPartnerGroupId() == null) {
					dealerInfo.setPartner_Group_Id("");
				} else {
					dealerInfo.setPartner_Group_Id(car.getCommercialGroup().getPartnerGroupId());
				}
				em.persist(dealerInfo);
				em.getTransaction().commit();
			}
			System.out.println("<-----------------End insertDealerInfos----------------------->");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertDealerInfos		--->" + e);
			throw e;
		}
	}

	private static void insertDrivelines(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null && car.getDriveline() != null) {
				em.getTransaction().begin();
				com.volvocars.ncl.model.Car carDrivelines = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.Driveline driveline = new com.volvocars.ncl.model.Driveline();
				driveline.setCar(carDrivelines);
				// DriveLine dL = car.getDriveline();

				
					if (car.getDriveline().getDriveLineId() == null) {
						driveline.setDriveLine_Id(Integer.parseInt(""));
						// driveline.setDriveLine_Id(Integer.parseInt(car.getDriveline().getDriveLineId()));
					} else {
						driveline.setDriveLine_Id(Integer.parseInt(car.getDriveline().getDriveLineId()));
					}
					if (car.getDriveline().getCo2Emission() == null) {
						driveline.setCO2_Emission("");
					} else {
						driveline.setCO2_Emission(car.getDriveline().getCo2Emission());
					}
					if (car.getDriveline().getDriveLineDescription() == null) {
						driveline.setDriveLine_Description("");
					} else {
						driveline.setDriveLine_Description(car.getDriveline().getDriveLineDescription());
					}
					if (car.getDriveline().getEfficiencyClass() == null) {
						driveline.setEfficiency_Class("");
					} else {
						driveline.setEfficiency_Class(car.getDriveline().getEfficiencyClass());
					}
					if (car.getDriveline().getFuelConsumption() == null) {
						driveline.setFuel_Consumption("");
					} else {
						driveline.setFuel_Consumption(car.getDriveline().getFuelConsumption());
					}
				
					em.persist(driveline);
					em.getTransaction().commit();
			}
		} catch (Exception e) {
			//em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("insertDrivelines		--->" + e.getMessage());
			throw e;
		}
	}

	private static void insertHiddenPackages(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null) {
				com.volvocars.ncl.model.Car carHiddenPackages = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.HiddenPackage hiddenPackagesModel = new com.volvocars.ncl.model.HiddenPackage();
				hiddenPackagesModel.setCar(carHiddenPackages);
				
				List<HideFeatures> hideFeaturesList = car.getHideFeatures();
				if (hideFeaturesList != null && hideFeaturesList.size() != 0) {
					em.getTransaction().begin();
					for (int i = 0; i < hideFeaturesList.size(); i++) {
						HideFeatures hideFeature = hideFeaturesList.get(i);
						if (hideFeature.getFeatureCode() == null) {
							hiddenPackagesModel.setFeature_Code("");
						} else {
							hiddenPackagesModel.setFeature_Code(hideFeature.getFeatureCode());
						}
						
						em.persist(hiddenPackagesModel);
						
					}

							
				/*if (car.getHideFeatures() != null && car.getHideFeatures().size() != 0) {
					em.getTransaction().begin();
					for (int j = 0; j < car.getHideFeatures().size(); j++) {
						HideFeatures hideFeatures = car.getHideFeatures().get(j);
						List<GroupFeature> featureList = hideFeatures.getFeature();
						if (featureList != null && featureList.size() != 0) {
							for (int i = 0; i < featureList.size(); i++) {
								GroupFeature groupFeature = featureList.get(i);
								com.volvocars.ncl.model.HiddenPackage hiddenPackage = new com.volvocars.ncl.model.HiddenPackage();
								hiddenPackage.setCar(carHiddenPackages);
								if (groupFeature.getFeatureCode() == null) {
									hiddenPackage.setFeature_Code("");
								} else {
									hiddenPackage.setFeature_Code(groupFeature.getFeatureCode());
								}
								em.persist(hiddenPackage);
							}

						}
					}*/
					// hiddenPackage.setFeature_Code(car.getf);
					em.getTransaction().commit();
				}
			}
			System.out.println("<-----------------End insertHiddenPackages----------------------->");
		} catch (Exception e) {
			System.out.println("insertHiddenPackages		--->" + e.getMessage());
			throw e;
		}
	}

	private static void insertOptionsFeatureCode(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null) {
				List optionsFeatureCodeList = car.getPno34Std().getOptionsFeatureCodeList();
				if (optionsFeatureCodeList.size() != 0 && optionsFeatureCodeList != null) {
					em.getTransaction().begin();
					com.volvocars.ncl.model.Car carOptionsFeatureCode = em.find(com.volvocars.ncl.model.Car.class,
							fyon);
					for (int i = 0; i < optionsFeatureCodeList.size(); i++) {
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
		} catch (Exception e) {
			System.out.println("insertOptionsFeatureCode		--->" + e.getMessage());
			throw e;
		}
	}

	private static void insertPackage(int fyon, com.volvocars.ncl.bo.Car car) {
		String packageName;
		String packageType;
		String packageCode;
		
		com.volvocars.ncl.model.Car carPackageFyon = em.find(com.volvocars.ncl.model.Car.class, fyon);
		com.volvocars.ncl.model.CarPackage carPackage ;
		try {
			System.out.println("Enter to insertPackage ----->" + car.getFyon());
			if (car != null) {				
				if (car.getPackage() != null && car.getPackage().size() != 0) {
					List<com.volvocars.ncl.bo.Package> packageList = car.getPackage();
					if (packageList != null || packageList.size() != 0) {
						em.getTransaction().begin();
						for(int i = 0; i<packageList.size(); i++){
							
							carPackage = new com.volvocars.ncl.model.CarPackage();
							carPackage.setCar(carPackageFyon);
							com.volvocars.ncl.bo.Package packList = packageList.get(i);
							packageName = packList.getName();
							packageType = packList.getType();
							packageCode = packList.getFeatureCode();
							
							List<GroupFeature> packFeature = packList.getGroupFeature();
							if(packFeature != null || packFeature.size() != 0){
								for(int j=0; j<packFeature.size(); j++){
									GroupFeature packageFeature = packFeature.get(j);
									
									if(packageName == null){
										carPackage.setPackage_Name("");
									}else{
										carPackage.setPackage_Name(packageName);
									}
									if(packageType == null){
										carPackage.setPackage_Type(Integer.parseInt(""));
									}else{
										carPackage.setPackage_Type(Integer.parseInt(packageType));
									}
									if(packageCode == null){
										carPackage.setPackage_Code("");
									}else{
										carPackage.setPackage_Code(packageCode);
									}
									if(packageFeature.getType() == null){
										carPackage.setFeature_Type(Integer.parseInt(""));
									}else{
										carPackage.setFeature_Type(Integer.parseInt(packageFeature.getType()));
									}
									if(packageFeature.getFeatureCode() == null){
										carPackage.setFeature_Code("");
									}else{
										carPackage.setFeature_Code(packageFeature.getFeatureCode());
									}
									em.persist(carPackage);
									
								}
							}
						}
						
					}
					em.getTransaction().commit();	
				} else {
					System.out.println("CarPackage is null-------------->");
				}
			}
			System.out.println("<-----------------End insertPackage----------------------->");
		} catch (Exception e) {
			System.out.println("insertPackage		--->" + e.getMessage());
			throw e;
		}
	}

	private static void insertPrice(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null) {
				em.getTransaction().begin();
				com.volvocars.ncl.model.Car carPrice = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.Price price = new com.volvocars.ncl.model.Price();
				price.setCar(carPrice);
				if (car.getPrice() != null) {
					if (car.getPrice().getCurrency() == null) {
						price.setCurrency("");
					} else {
						price.setCurrency(car.getPrice().getCurrency());
					}
					if (car.getPrice().getBasicPrice() == null || car.getPrice().getBasicPrice().getName() == null) {
						price.setBasic_Price_Name("");
					} else {
						price.setBasic_Price_Name(car.getPrice().getBasicPrice().getName());
					}
					if (car.getPrice().getBasicPrice() == null || car.getPrice().getBasicPrice().getValue() == null) {
						price.setBasic_Price_Value("");
					} else {
						price.setBasic_Price_Value(car.getPrice().getBasicPrice().getValue());
					}
					if (car.getPrice().getDeliveryCharge() == null
							|| car.getPrice().getDeliveryCharge().getName() == null) {
						price.setDelivery_Charge_Name("");
					} else {
						price.setDelivery_Charge_Name(car.getPrice().getDeliveryCharge().getName());
					}
					if (car.getPrice().getDeliveryCharge() == null
							|| car.getPrice().getDeliveryCharge().getValue() == null) {
						price.setDelivery_Charge_Value("");
					} else {
						price.setDelivery_Charge_Value(car.getPrice().getDeliveryCharge().getValue());
					}
					if (car.getPrice().getRetailPriceBeforeTax() == null
							|| car.getPrice().getRetailPriceBeforeTax().getName() == null) {
						price.setRetail_Price_Before_Tax_Name("");
					} else {
						price.setRetail_Price_Before_Tax_Name(car.getPrice().getRetailPriceBeforeTax().getName());
					}
					if (car.getPrice().getRetailPriceBeforeTax() == null
							|| car.getPrice().getRetailPriceBeforeTax().getValue() == null) {
						price.setRetail_Price_Before_Tax_Value("");
					} else {
						price.setRetail_Price_Before_Tax_Value(car.getPrice().getRetailPriceBeforeTax().getValue());
					}
					if (car.getPrice().getTax1() == null || car.getPrice().getTax1().getName() == null) {
						price.setTax1_Name("");
					} else {
						price.setTax1_Name(car.getPrice().getTax1().getName());
					}
					if (car.getPrice().getTax1() == null || car.getPrice().getTax1().getValue() == null) {
						price.setTax1_Value("");
					} else {
						price.setTax1_Value(car.getPrice().getTax1().getValue());
					}

					if (car.getPrice().getTax2() == null || car.getPrice().getTax2().getName() == null) {
						price.setTax2_Name("");
					} else {
						price.setTax2_Name(car.getPrice().getTax2().getName());
					}
					if (car.getPrice().getTax2() == null || car.getPrice().getTax2().getValue() == null) {
						price.setTax2_Value("");
					} else {
						price.setTax2_Value(car.getPrice().getTax2().getValue());
					}

					if (car.getPrice().getTax3() == null || car.getPrice().getTax3().getName() == null) {
						price.setTax3_Name("");
					} else {
						price.setTax3_Name(car.getPrice().getTax3().getName());
					}
					if (car.getPrice().getTax3() == null || car.getPrice().getTax3().getValue() == null) {
						price.setTax3_Value("");
					} else {
						price.setTax3_Value(car.getPrice().getTax3().getValue());
					}

					if (car.getPrice().getTax4() == null || car.getPrice().getTax4().getName() == null) {
						price.setTax4_Name("");
					} else {
						price.setTax4_Name(car.getPrice().getTax4().getName());
					}
					if (car.getPrice().getTax4() == null || car.getPrice().getTax4().getValue() == null) {
						price.setTax4_Value("");
					} else {
						price.setTax4_Value(car.getPrice().getTax4().getValue());
					}

					if (car.getPrice().getTotalPrice() == null || car.getPrice().getTotalPrice().getName() == null) {
						price.setTotal_Price_Name("");
					} else {
						price.setTotal_Price_Name(car.getPrice().getTotalPrice().getName());
					}

					if (car.getPrice().getTotalPrice() == null || car.getPrice().getTotalPrice().getValue() == null) {
						price.setTotal_Price_Value("");
					} else {
						price.setTotal_Price_Value(car.getPrice().getTotalPrice().getValue());
					}

					if (car.getPrice() == null || car.getPrice().getTotalTaxAmount() == null) {
						price.setTotal_Tax_Amount("");
					} else {
						price.setTotal_Tax_Amount(car.getPrice().getTotalTaxAmount());
					}
					
					if (car.getPrice().getTotalVATAmount() == null || car.getPrice().getTotalVATAmount().getName() == null) {
						price.setTotal_VATAmt_Name("");
					} else {
						price.setTotal_VATAmt_Name(car.getPrice().getTotalVATAmount().getName());
					}

					if (car.getPrice().getTotalVATAmount() == null || car.getPrice().getTotalVATAmount().getValue() == null) {
						price.setTotal_VATAmt_Value("");
					} else {
						price.setTotal_VATAmt_Value(car.getPrice().getTotalVATAmount().getValue());
					}

					// price.setUrax_Taxes("");
					em.persist(price);
					em.getTransaction().commit();
				}
			}
			System.out.println("<-----------------End insertPrice----------------------->");
		} catch (Exception e) {
			System.out.println("insertPrice		--->" + e.getMessage());
			throw e;
		}
	}

	private static void insertUraxTaxes(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null) {
				
				com.volvocars.ncl.model.Car carUrax = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.UraxTaxe uraxTaxesModel ;

				List<UraxTaxes> uraxList = car.getPrice().getUraxTaxes();
				if (uraxList != null && uraxList.size() != 0) {
					for (int i = 0; i < uraxList.size(); i++) {
						em.getTransaction().begin();
						uraxTaxesModel = new com.volvocars.ncl.model.UraxTaxe();
						uraxTaxesModel.setCar(carUrax);
						UraxTaxes uraxtax = uraxList.get(i);
						if (uraxtax.getVatPosition() == null) {
							uraxTaxesModel.setVAT_Position("");
						} else {
							uraxTaxesModel.setVAT_Position(uraxtax.getVatPosition());
						}
						if (uraxtax.getTaxid() == null) {
							uraxTaxesModel.setTax_Id("");
						} else {
							uraxTaxesModel.setTax_Id(uraxtax.getTaxid());
						}
						if (uraxtax.getTaxVersion() == null) {
							uraxTaxesModel.setTax_Version("");
						} else {
							uraxTaxesModel.setTax_Version(uraxtax.getTaxVersion());
						}
						if (uraxtax.getName() == null) {
							uraxTaxesModel.setTax_Name("");
						} else {
							uraxTaxesModel.setTax_Name(uraxtax.getName());
						}
						if (uraxtax.getValue() == null) {
							uraxTaxesModel.setTax_Value("");
						} else {
							uraxTaxesModel.setTax_Value(uraxtax.getValue());
						}
						em.persist(uraxTaxesModel);
						em.getTransaction().commit();
					}
					
				}
				
			}
			System.out.println("<------*----------End insertUraxTaxesDetails--------------*-------->");

		} catch (Exception e) {
			System.out.println("insertUraxTaxesDetails		--->" + e);
			throw e;
		}
	}

	private static void insertNedcRrcx(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null) {
				
				com.volvocars.ncl.model.Car carNedc = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.Nedc NedcRrcx;

				List<NedcRrcx> nedcList = car.getNedcRrcx();
				if (nedcList != null && nedcList.size() != 0) {
					for (int i = 0; i < nedcList.size(); i++) {
						
						NedcRrcx nedc = nedcList.get(i);
						List<Co2Parameter> co2ParameterList = nedc.getCo2Parameter();
						if (co2ParameterList != null && co2ParameterList.size() != 0) {
							for (int j = 0; j < co2ParameterList.size(); j++) {
								em.getTransaction().begin();
								NedcRrcx = new com.volvocars.ncl.model.Nedc();
								NedcRrcx.setCar(carNedc);
								
								Co2Parameter co2Values = co2ParameterList.get(j);
								if (co2Values.getName() == null) {
									NedcRrcx.setNEDC_Type("");
								} else {
									NedcRrcx.setNEDC_Type(co2Values.getName());
								}
								if (co2Values.getDescription() == null) {
									NedcRrcx.setNEDC_Description("");
								} else {
									NedcRrcx.setNEDC_Description(co2Values.getDescription());
								}
								if (co2Values.getValue() == null) {
									NedcRrcx.setNEDC_Value("");
								} else {
									NedcRrcx.setNEDC_Value(co2Values.getValue());
								}
								if (co2Values.getUnit() == null) {
									NedcRrcx.setNEDC_Unit("");
								} else {
									NedcRrcx.setNEDC_Unit(co2Values.getUnit());
								}
								if (co2Values.getRedaName() == null) {
									NedcRrcx.setNEDC_RedaName("");
								} else {
									NedcRrcx.setNEDC_RedaName(co2Values.getRedaName());
								}
								em.persist(NedcRrcx);
								em.getTransaction().commit();
							}
						}

					}
					
				}
				
			}
			System.out.println("<------*----------End insertNedcDetails--------------*-------->");

		} catch (Exception e) {
			System.out.println("insertNedcDetails		--->" + e);
			throw e;
		}
	}

	private static void insertWltp(int fyon, com.volvocars.ncl.bo.Car car) {
		try {
			if (car != null) {
				
				com.volvocars.ncl.model.Car carWltp = em.find(com.volvocars.ncl.model.Car.class, fyon);
				com.volvocars.ncl.model.Wltp wltpModel ;

				List<WLTP> wltpList = car.getWltp();
				if (wltpList != null && wltpList.size() != 0) {
					for (int i = 0; i < wltpList.size(); i++) {
						
						WLTP wltp = wltpList.get(i);
						List<Co2Parameter> co2ParameterList = wltp.getCo2Parameter();
						if (co2ParameterList != null && co2ParameterList.size() != 0) {
							for (int j = 0; j < co2ParameterList.size(); j++) {
								em.getTransaction().begin();
								 wltpModel = new com.volvocars.ncl.model.Wltp();
								 wltpModel.setCar(carWltp);
								Co2Parameter co2Values = co2ParameterList.get(j);
								if (co2Values.getName() == null) {
									wltpModel.setWLTP_Name("");
								} else {
									wltpModel.setWLTP_Name(co2Values.getName());
								}
								if (co2Values.getDescription() == null) {
									wltpModel.setWLTP_Description("");
								} else {
									wltpModel.setWLTP_Description(co2Values.getDescription());
								}
								if (co2Values.getValue() == null) {
									wltpModel.setWLTP_Value("");
								} else {
									wltpModel.setWLTP_Value(co2Values.getValue());
								}
								if (co2Values.getUnit() == null) {
									wltpModel.setWLTP_Unit("");
								} else {
									wltpModel.setWLTP_Unit(co2Values.getUnit());
								}
								if (co2Values.getRedaName() == null) {
									wltpModel.setWLTP_RedaName("");
								} else {
									wltpModel.setWLTP_RedaName(co2Values.getRedaName());
								}
								em.persist(wltpModel);
								em.getTransaction().commit();
							}
						}

					}
					
				}
				
			}
			System.out.println("<------*----------End insertWLTPDetails--------------*-------->");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertWLTPDetails		--->" + e);
			throw e;
		}
	}

	public static void insertCarFeatureTypeGroups(com.volvocars.ncl.bo.FeatureTypeGroups featuretypegroup) {
		String type;
		String name;
		String groupId;
		String groupName;
		com.volvocars.ncl.model.CarGroup groupModel;
		try {
			if (featuretypegroup != null) {

				em.getTransaction().begin();

				type = featuretypegroup.getType();
				name = featuretypegroup.getName();

				List<Groups> groupsList = featuretypegroup.getGroup();
				if (groupsList != null && groupsList.size() != 0) {
					for (int i = 0; i < groupsList.size(); i++) {
						Groups group = groupsList.get(i);

						groupId = group.getId();
						groupName = group.getName();
						List<GroupFeature> groupFeatureList = group.getFeature();
						if (groupFeatureList != null && groupFeatureList.size() != 0) {
							for (int j = 0; j < groupFeatureList.size(); j++) {
								GroupFeature groupFeature = groupFeatureList.get(j);

								/*
								 * groupFeatureType = groupFeature.getType();
								 * groupFeatureName = groupFeature.getname();
								 * groupFeatureCode =
								 * groupFeature.getFeatureCode();
								 */

								groupModel = new com.volvocars.ncl.model.CarGroup();

								/*
								 * groupModel.setSub_Group_Name("Test");
								 * groupModel.setSub_Group_Type_Id(0);
								 */
								if (type == null) {
									groupModel.setFeature_Type_Group_Id(Integer.parseInt(""));
								} else {
									groupModel.setFeature_Type_Group_Id(Integer.parseInt(type));
								}
								if (name == null) {
									groupModel.setFeature_Type_Group_Name("");
								} else {
									groupModel.setFeature_Type_Group_Name(name);
								}

								if (groupFeature.getFeatureCode() == null) {
									groupModel.setFeature_Code("");
								} else {
									groupModel.setFeature_Code(groupFeature.getFeatureCode());
								}

								if (groupFeature.getType() == null) {
									groupModel.setFeature_Type(Integer.parseInt(""));
								} else {
									groupModel.setFeature_Type(Integer.parseInt(groupFeature.getType()));
								}

								if (groupId == null) {
									groupModel.setGroup_Id("");
								} else {
									groupModel.setGroup_Id(group.getId());
								}
								if (groupName == null) {
									groupModel.setGroup_Name("");
								} else {
									groupModel.setGroup_Name(groupName);
								}

								em.persist(groupModel);
							}
						}
					}
				}

				/*
				 * List<com.volvocars.ncl.bo.FeatureTypeGroups>
				 * featureTypeGroupsList = featuretypegroup.getGroup();
				 * if(groupList != null && groupList.size() != 0){ for(int
				 * i=0;i<groupList.size();i++){ com.volvocars.ncl.bo.Groups
				 * groupBO = groupList.get(i);
				 * 
				 * List<GroupFeature> featureBoList = groupBO.getFeature();
				 * if(featureBoList != null && featureBoList.size() != 0){
				 * for(int j=0;j<featureBoList.size();j++){ GroupFeature
				 * groupFeature = featureBoList.get(j); groupModel = new
				 * com.volvocars.ncl.model.CarGroup();
				 * 
				 * if(name == null){ groupModel.setGroup_Name(""); }else{
				 * groupModel.setGroup_Name(name); } if(groupBO.() == null){
				 * groupModel.setSub_Group_Type_Id(Integer.parseInt("")); }else{
				 * groupModel.setSub_Group_Type_Id(Integer.parseInt(groupBO.
				 * getType())); } if(groupBO.getName() == null){
				 * groupModel.setSub_Group_Name(""); }else{
				 * groupModel.setSub_Group_Name( groupBO.getName()); }
				 * 
				 * if(groupFeature.getFeatureCode() == null){
				 * groupModel.setFeature_Code(""); }else{
				 * groupModel.setFeature_Code(groupFeature.getFeatureCode()); }
				 * 
				 * 
				 * if(groupFeature.getType() == null){
				 * groupModel.setGroup_Id(Integer.parseInt("")); }else{
				 * groupModel.setGroup_Id(Integer.parseInt(groupFeature.getType(
				 * ))); } em.persist(groupModel); }
				 * 
				 * }
				 * 
				 * } }
				 */
				em.getTransaction().commit();
			}
			System.out.println("<-----------------End insertCarGroups----------------------->");
		} catch (Exception e) {
			System.out.println("Error --->" + e.getMessage());
			throw e;

		}

	}

	public static void insertFeatures(com.volvocars.ncl.bo.FeaturesList features) {
		// TODO Auto-generated method stub
		com.volvocars.ncl.model.Feature feature;
		try {

			String typeMissed;
			em.getTransaction().begin();
			com.volvocars.ncl.model.TypeMaster typeMaster = em.find(com.volvocars.ncl.model.TypeMaster.class,Integer.parseInt(features.getType()));

			if (typeMaster != null) {
				
				
					

						feature = new com.volvocars.ncl.model.Feature();
						feature.setTypeMaster(typeMaster);
						if (features.getFeatureCode() == null) {
							feature.setFeature_Code("");
						} else {
							feature.setFeature_Code(features.getFeatureCode());
						}
						if (features.getDescription() == null) {
							feature.setFeature_Description("");

						} else {
							feature.setFeature_Description(features.getDescription());
						}
						if (features.getName() == null) {
							feature.setFeature_Name("");
						} else{
							feature.setFeature_Name(features.getName());
						}
						if(features.getModelYear() == null){
							features.setModelYear("");
						}else {

							feature.setModel_Year(Integer.parseInt(features.getModelYear()));
						}
						/*List<Feature> f = new ArrayList<>();
								f.add(feature);
						typeMaster.setFeatureList(f);*/
						em.persist(feature);
					
					em.getTransaction().commit();
				
			} else {
				typeMissed = features.getType();
				typeMissed = typeMissed + ":";
				System.out.println("Type code is not available in TypeMaster--->" + typeMissed);
			}
			System.out.println("<-----------------End insertFeatures----------------------->");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error --->" + e.getMessage());
			throw e;
		}
	}

	public static void deleteRecords() {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			Query DealerDetails = em.createNativeQuery("DELETE FROM Dealer_Details;");
			Query featuresTable = em.createNativeQuery("DELETE FROM FEATURES");
			Query carGroupTable = em.createNativeQuery("DELETE FROM CAR_GROUP");
			Query priceTable = em.createNativeQuery("DELETE FROM PRICE");
			Query carPackageTable = em.createNativeQuery("DELETE FROM CAR_PACKAGE");
			Query featureCodeTable = em.createNativeQuery("DELETE FROM OPTIONS_FEATURE_CODE");
			Query hiddenPackageTable = em.createNativeQuery("DELETE FROM HIDDEN_PACKAGE");
			Query driveLineTable = em.createNativeQuery("DELETE FROM DRIVELINE");
			Query dealerInfoTable = em.createNativeQuery("DELETE FROM DEALER_INFO");
			Query variantsTable = em.createNativeQuery("DELETE FROM VARIANTS");
			Query carTable = em.createNativeQuery("DELETE FROM CARS");
			Query wltpTable = em.createNativeQuery("DELETE FROM WLTP");
			Query nedcTable = em.createNativeQuery("DELETE FROM NEDC");
			Query uraxTaxTable = em.createNativeQuery("DELETE FROM URAX_TAXES");

			DealerDetails.executeUpdate();
			featuresTable.executeUpdate();
			carGroupTable.executeUpdate();
			priceTable.executeUpdate();
			carPackageTable.executeUpdate();
			featureCodeTable.executeUpdate();
			hiddenPackageTable.executeUpdate();
			driveLineTable.executeUpdate();
			dealerInfoTable.executeUpdate();
			variantsTable.executeUpdate();
			wltpTable.executeUpdate();
			nedcTable.executeUpdate();
			uraxTaxTable.executeUpdate();
			carTable.executeUpdate();
			

			em.getTransaction().commit();
			System.out.println("<-----------------End deleteRecords----------------------->");
		} catch (Exception e) {
			System.out.println("Error --->" + e.getMessage());
			throw e;
		}
	}

}
