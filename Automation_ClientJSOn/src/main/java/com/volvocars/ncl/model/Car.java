package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CARS database table.
 * 
 */
@Entity
@Table(name="CARS")
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FYON")
	private int fyon;

	@Column(name="Accessories")
	private String accessories;

	@Column(name="Brand_Order_Type")
	private String brand_Order_Type;

	/*@Column(name="CARS_NO")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int carsNo;*/

	@Column(name="Color")
	private String color;

	@Column(name="CommercialModelYear")
	private String commercialModelYear;

	@Column(name="Common_Status_Point")
	private String common_Status_Point;

	@Column(name="DealerFittedAccessories")
	private String dealerFittedAccessories;

	@Column(name="Delivery_Date")
	private String delivery_Date;

	@Column(name="Destination_Code")
	private String destination_Code;

	@Column(name="Distance_KM")
	private String distance_KM;

	@Column(name="Engine")
	private String engine;

	@Column(name="GearBox")
	private String gearBox;

	@Column(name="Intermediate_Destination_Code")
	private String intermediate_Destination_Code;

	@Column(name="IsNSCStockCar")
	private String isNSCStockCar;

	@Column(name="IsURAX")
	private String isURAX;

	@Column(name="IsWLTP")
	private String isWLTP;

	@Column(name="LDOC")
	private String ldoc;

	@Column(name="MarketingCode")
	private String marketingCode;

	@Column(name="Model")
	private String model;

	@Column(name="Model_Name")
	private String model_Name;

	@Column(name="Model_Year")
	private int model_Year;

	@Column(name="NedcRrcx")
	private String nedcRrcx;

	@Column(name="NoSpecAvailable")
	private String noSpecAvailable;

	@Column(name="Options")
	private String options;

	@Column(name="Order_Number")
	private String order_Number;

	@Column(name="Ownership")
	private String ownership;

	@Column(name="Partner")
	private String partner;

	@Column(name="PNO34")
	private String pno34;

	@Column(name="Price_Date")
	private String price_Date;

	@Column(name="Price_List")
	private String price_List;

	@Column(name="Registration_Number")
	private String registration_Number;

	@Column(name="SalesVersion")
	private String salesVersion;

	@Column(name="SMessage")
	private String SMessage;

	@Column(name="Steering")
	private String steering;

	@Column(name="Structure_Week")
	private String structure_Week;

	@Column(name="SunRoof")
	private String sunRoof;

	@Column(name="TaxCalcBasedOn")
	private String taxCalcBasedOn;

	@Column(name="Trade_Type")
	private String trade_Type;

	@Column(name="Upholstery")
	private String upholstery;

	@Column(name="Variant_Feature_Code")
	private String variant_Feature_Code;

	@Column(name="VIN")
	private String vin;

	@Column(name="WLTPI")
	private String wltpi;
	
	@Column(name="Efficiency_Class")
	private String efficiency_Class;

	//bi-directional many-to-one association to DealerDetail
	@OneToMany(mappedBy="car")
	private List<DealerDetail> dealerDetails;

	//bi-directional many-to-one association to DealerInfo
	@OneToMany(mappedBy="car")
	private List<DealerInfo> dealerInfos;

	//bi-directional many-to-one association to Driveline
	@OneToMany(mappedBy="car")
	private List<Driveline> drivelines;

	//bi-directional many-to-one association to HiddenPackage
	@OneToMany(mappedBy="car")
	private List<HiddenPackage> hiddenPackages;

	//bi-directional many-to-one association to Nedc
	@OneToMany(mappedBy="car")
	private List<Nedc> nedcs;

	//bi-directional many-to-one association to OptionsFeatureCode
	@OneToMany(mappedBy="car")
	private List<OptionsFeatureCode> optionsFeatureCodes;

	//bi-directional many-to-one association to Price
	@OneToMany(mappedBy="car")
	private List<Price> prices;

	//bi-directional many-to-one association to UraxTaxe
	@OneToMany(mappedBy="car")
	private List<UraxTaxe> uraxTaxes;

	//bi-directional many-to-one association to Variant
	@OneToMany(mappedBy="car")
	private List<Variant> variants;

	//bi-directional many-to-one association to Wltp
	@OneToMany(mappedBy="car")
	private List<Wltp> wltps;

	//bi-directional many-to-one association to CarPackage
	@OneToMany(mappedBy="car")
	private List<CarPackage> carPackages;

	public Car() {
	}

	public int getFyon() {
		return this.fyon;
	}

	public void setFyon(int fyon) {
		this.fyon = fyon;
	}

	public String getAccessories() {
		return this.accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public String getBrand_Order_Type() {
		return this.brand_Order_Type;
	}

	public void setBrand_Order_Type(String brand_Order_Type) {
		this.brand_Order_Type = brand_Order_Type;
	}
/*
	public int getCarsNo() {
		return this.carsNo;
	}

	public void setCarsNo(int carsNo) {
		this.carsNo = carsNo;
	}*/

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCommercialModelYear() {
		return this.commercialModelYear;
	}

	public void setCommercialModelYear(String commercialModelYear) {
		this.commercialModelYear = commercialModelYear;
	}

	public String getCommon_Status_Point() {
		return this.common_Status_Point;
	}

	public void setCommon_Status_Point(String common_Status_Point) {
		this.common_Status_Point = common_Status_Point;
	}

	public String getDealerFittedAccessories() {
		return this.dealerFittedAccessories;
	}

	public void setDealerFittedAccessories(String dealerFittedAccessories) {
		this.dealerFittedAccessories = dealerFittedAccessories;
	}

	public String getDelivery_Date() {
		return this.delivery_Date;
	}

	public void setDelivery_Date(String delivery_Date) {
		this.delivery_Date = delivery_Date;
	}

	public String getDestination_Code() {
		return this.destination_Code;
	}

	public void setDestination_Code(String destination_Code) {
		this.destination_Code = destination_Code;
	}

	public String getDistance_KM() {
		return this.distance_KM;
	}

	public void setDistance_KM(String distance_KM) {
		this.distance_KM = distance_KM;
	}

	public String getEngine() {
		return this.engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getGearBox() {
		return this.gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public String getIntermediate_Destination_Code() {
		return this.intermediate_Destination_Code;
	}

	public void setIntermediate_Destination_Code(String intermediate_Destination_Code) {
		this.intermediate_Destination_Code = intermediate_Destination_Code;
	}

	public String getIsNSCStockCar() {
		return this.isNSCStockCar;
	}

	public void setIsNSCStockCar(String isNSCStockCar) {
		this.isNSCStockCar = isNSCStockCar;
	}

	public String getIsURAX() {
		return this.isURAX;
	}

	public void setIsURAX(String isURAX) {
		this.isURAX = isURAX;
	}

	public String getIsWLTP() {
		return this.isWLTP;
	}

	public void setIsWLTP(String isWLTP) {
		this.isWLTP = isWLTP;
	}

	public String getLdoc() {
		return this.ldoc;
	}

	public void setLdoc(String ldoc) {
		this.ldoc = ldoc;
	}

	public String getMarketingCode() {
		return this.marketingCode;
	}

	public void setMarketingCode(String marketingCode) {
		this.marketingCode = marketingCode;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel_Name() {
		return this.model_Name;
	}

	public void setModel_Name(String model_Name) {
		this.model_Name = model_Name;
	}

	public int getModel_Year() {
		return this.model_Year;
	}

	public void setModel_Year(int model_Year) {
		this.model_Year = model_Year;
	}

	public String getNedcRrcx() {
		return this.nedcRrcx;
	}

	public void setNedcRrcx(String nedcRrcx) {
		this.nedcRrcx = nedcRrcx;
	}

	public String getNoSpecAvailable() {
		return this.noSpecAvailable;
	}

	public void setNoSpecAvailable(String noSpecAvailable) {
		this.noSpecAvailable = noSpecAvailable;
	}

	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getOrder_Number() {
		return this.order_Number;
	}

	public void setOrder_Number(String order_Number) {
		this.order_Number = order_Number;
	}

	public String getOwnership() {
		return this.ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getPno34() {
		return this.pno34;
	}

	public void setPno34(String pno34) {
		this.pno34 = pno34;
	}

	public String getPrice_Date() {
		return this.price_Date;
	}

	public void setPrice_Date(String price_Date) {
		this.price_Date = price_Date;
	}

	public String getPrice_List() {
		return this.price_List;
	}

	public void setPrice_List(String price_List) {
		this.price_List = price_List;
	}

	public String getRegistration_Number() {
		return this.registration_Number;
	}

	public void setRegistration_Number(String registration_Number) {
		this.registration_Number = registration_Number;
	}

	public String getSalesVersion() {
		return this.salesVersion;
	}

	public void setSalesVersion(String salesVersion) {
		this.salesVersion = salesVersion;
	}

	public String getSMessage() {
		return this.SMessage;
	}

	public void setSMessage(String SMessage) {
		this.SMessage = SMessage;
	}

	public String getSteering() {
		return this.steering;
	}

	public void setSteering(String steering) {
		this.steering = steering;
	}

	public String getStructure_Week() {
		return this.structure_Week;
	}

	public void setStructure_Week(String structure_Week) {
		this.structure_Week = structure_Week;
	}

	public String getSunRoof() {
		return this.sunRoof;
	}

	public void setSunRoof(String sunRoof) {
		this.sunRoof = sunRoof;
	}

	public String getTaxCalcBasedOn() {
		return this.taxCalcBasedOn;
	}

	public void setTaxCalcBasedOn(String taxCalcBasedOn) {
		this.taxCalcBasedOn = taxCalcBasedOn;
	}

	public String getTrade_Type() {
		return this.trade_Type;
	}

	public void setTrade_Type(String trade_Type) {
		this.trade_Type = trade_Type;
	}

	public String getUpholstery() {
		return this.upholstery;
	}

	public void setUpholstery(String upholstery) {
		this.upholstery = upholstery;
	}

	public String getVariant_Feature_Code() {
		return this.variant_Feature_Code;
	}

	public void setVariant_Feature_Code(String variant_Feature_Code) {
		this.variant_Feature_Code = variant_Feature_Code;
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getWltpi() {
		return this.wltpi;
	}

	public void setWltpi(String wltpi) {
		this.wltpi = wltpi;
	}

	public List<DealerDetail> getDealerDetails() {
		return this.dealerDetails;
	}

	public void setDealerDetails(List<DealerDetail> dealerDetails) {
		this.dealerDetails = dealerDetails;
	}

	public DealerDetail addDealerDetail(DealerDetail dealerDetail) {
		getDealerDetails().add(dealerDetail);
		dealerDetail.setCar(this);

		return dealerDetail;
	}

	public DealerDetail removeDealerDetail(DealerDetail dealerDetail) {
		getDealerDetails().remove(dealerDetail);
		dealerDetail.setCar(null);

		return dealerDetail;
	}

	public List<DealerInfo> getDealerInfos() {
		return this.dealerInfos;
	}

	public void setDealerInfos(List<DealerInfo> dealerInfos) {
		this.dealerInfos = dealerInfos;
	}

	public DealerInfo addDealerInfo(DealerInfo dealerInfo) {
		getDealerInfos().add(dealerInfo);
		dealerInfo.setCar(this);

		return dealerInfo;
	}

	public DealerInfo removeDealerInfo(DealerInfo dealerInfo) {
		getDealerInfos().remove(dealerInfo);
		dealerInfo.setCar(null);

		return dealerInfo;
	}

	public List<Driveline> getDrivelines() {
		return this.drivelines;
	}

	public void setDrivelines(List<Driveline> drivelines) {
		this.drivelines = drivelines;
	}

	public Driveline addDriveline(Driveline driveline) {
		getDrivelines().add(driveline);
		driveline.setCar(this);

		return driveline;
	}

	public Driveline removeDriveline(Driveline driveline) {
		getDrivelines().remove(driveline);
		driveline.setCar(null);

		return driveline;
	}

	public List<HiddenPackage> getHiddenPackages() {
		return this.hiddenPackages;
	}

	public void setHiddenPackages(List<HiddenPackage> hiddenPackages) {
		this.hiddenPackages = hiddenPackages;
	}

	public HiddenPackage addHiddenPackage(HiddenPackage hiddenPackage) {
		getHiddenPackages().add(hiddenPackage);
		hiddenPackage.setCar(this);

		return hiddenPackage;
	}

	public HiddenPackage removeHiddenPackage(HiddenPackage hiddenPackage) {
		getHiddenPackages().remove(hiddenPackage);
		hiddenPackage.setCar(null);

		return hiddenPackage;
	}

	public List<Nedc> getNedcs() {
		return this.nedcs;
	}

	public void setNedcs(List<Nedc> nedcs) {
		this.nedcs = nedcs;
	}

	public Nedc addNedc(Nedc nedc) {
		getNedcs().add(nedc);
		nedc.setCar(this);

		return nedc;
	}

	public Nedc removeNedc(Nedc nedc) {
		getNedcs().remove(nedc);
		nedc.setCar(null);

		return nedc;
	}

	public List<OptionsFeatureCode> getOptionsFeatureCodes() {
		return this.optionsFeatureCodes;
	}

	public void setOptionsFeatureCodes(List<OptionsFeatureCode> optionsFeatureCodes) {
		this.optionsFeatureCodes = optionsFeatureCodes;
	}

	public OptionsFeatureCode addOptionsFeatureCode(OptionsFeatureCode optionsFeatureCode) {
		getOptionsFeatureCodes().add(optionsFeatureCode);
		optionsFeatureCode.setCar(this);

		return optionsFeatureCode;
	}

	public OptionsFeatureCode removeOptionsFeatureCode(OptionsFeatureCode optionsFeatureCode) {
		getOptionsFeatureCodes().remove(optionsFeatureCode);
		optionsFeatureCode.setCar(null);

		return optionsFeatureCode;
	}

	public List<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public Price addPrice(Price price) {
		getPrices().add(price);
		price.setCar(this);

		return price;
	}

	public Price removePrice(Price price) {
		getPrices().remove(price);
		price.setCar(null);

		return price;
	}

	public List<UraxTaxe> getUraxTaxes() {
		return this.uraxTaxes;
	}

	public void setUraxTaxes(List<UraxTaxe> uraxTaxes) {
		this.uraxTaxes = uraxTaxes;
	}

	public UraxTaxe addUraxTaxe(UraxTaxe uraxTaxe) {
		getUraxTaxes().add(uraxTaxe);
		uraxTaxe.setCar(this);

		return uraxTaxe;
	}

	public UraxTaxe removeUraxTaxe(UraxTaxe uraxTaxe) {
		getUraxTaxes().remove(uraxTaxe);
		uraxTaxe.setCar(null);

		return uraxTaxe;
	}

	public List<Variant> getVariants() {
		return this.variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}

	public Variant addVariant(Variant variant) {
		getVariants().add(variant);
		variant.setCar(this);

		return variant;
	}

	public Variant removeVariant(Variant variant) {
		getVariants().remove(variant);
		variant.setCar(null);

		return variant;
	}

	public List<Wltp> getWltps() {
		return this.wltps;
	}

	public void setWltps(List<Wltp> wltps) {
		this.wltps = wltps;
	}

	public Wltp addWltp(Wltp wltp) {
		getWltps().add(wltp);
		wltp.setCar(this);

		return wltp;
	}

	public Wltp removeWltp(Wltp wltp) {
		getWltps().remove(wltp);
		wltp.setCar(null);

		return wltp;
	}

	public List<CarPackage> getCarPackages() {
		return this.carPackages;
	}

	public void setCarPackages(List<CarPackage> carPackages) {
		this.carPackages = carPackages;
	}

	public CarPackage addCarPackage(CarPackage carPackage) {
		getCarPackages().add(carPackage);
		carPackage.setCar(this);

		return carPackage;
	}

	public CarPackage removeCarPackage(CarPackage carPackage) {
		getCarPackages().remove(carPackage);
		carPackage.setCar(null);

		return carPackage;
	}

	public String getEfficiency_Class() {
		return efficiency_Class;
	}

	public void setEfficiency_Class(String efficiency_Class) {
		this.efficiency_Class = efficiency_Class;
	}

}