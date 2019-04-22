package com.volvocars.ncl.bo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author tmohamed
 *
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Car {
	
	private String pno34;
	private String fyon;
	private String vin;
	private String registrationNumber;
	private String modelYear;
	private String structureWeek;
	private String contentStructureWeek;
	private String dealerSiteCode;
	private String deliveryDate;
	private String destinationCode;
	private String intermediateDestinationCode;
	private String distance;
	private AreaGroup areaGroup = new AreaGroup();
	private ContactInfo contactInfo = new ContactInfo();
	private String commonStatusPoint;	
	private String position;
	private List<Package> packages = new ArrayList<Package>();
	private List<HideFeatures> HideFeatures = new ArrayList<HideFeatures>();
	private String priceDate;
	private String priceList;
	private String name;
	private Price  Price = new Price();
	private Co2 co2 = new Co2();
	private String noSpecAvailable;
	private String ldoc;
	private String orderType;
	private String commonOrderNumber;
	private String Ownership;
	private String PartnerGroupId;
	private String TradeType;
	private CommercialGroup CommercialGroup = new CommercialGroup();
	private String IsNscStockCar;
	private String market;
	private String updatedPrice;
	private String isPriceupdated;
	private String expiryDate;
	private String isUpdatedAllowed;
	private String gccPrice;
	//private String Driveline;
	//private String Accessories;
	private String accessoriesConcatenated;
	private String CommercialModelYear;
	private String efficiencyClass;
	private String taxCalcBasedOn;
	private String IsWLTP;
	private String IsURAX;
	private String co2Extrainformation;
	private String selectedFeatureCode;
	private String portLocation;
	private String dealerFittedAccessories;
	private String ModelCode;
	private String IsReda;
	private String sender;
	private String showBasicPrice;
	private String taxationDate;
	private List<NedcRrcx> NedcRrcx = new ArrayList<NedcRrcx>();
	private List<WLTP> Wltp = new ArrayList<WLTP>();
	private String WLTPI;
	private List<Error> Error = new ArrayList<Error>();
	private Pno34Std pno34Std = new Pno34Std();
	private DriveLine driveLineInfo = new DriveLine();
	private List<Variants> Variants = new ArrayList<Variants>();
	//private Weight weight = new Weight();
	private String endOfSeries;
	private String carType;
	
	
	public String getPno34() {		
		return pno34;
	}
	public void setPno34(String pno34) {
		this.pno34 = pno34;		
	}
	
	@JsonProperty
	public String getFyon() {
		return fyon;
	}
	public void setFyon(String fyon) {
		this.fyon = fyon;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		if(vin == null){
			this.vin = "";
		}else {
			this.vin = vin;
		}
		
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		if(registrationNumber == null){
			this.registrationNumber = "";
		}else {
			this.registrationNumber = registrationNumber;
		}
		
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public String getStructureWeek() {
		return structureWeek;
	}
	public void setStructureWeek(String structureWeek) {
		if(structureWeek == null){
			this.structureWeek = "";
		}else {
			this.structureWeek = structureWeek;
		}
		
	}
	public String getdealerSiteCode() {
		return dealerSiteCode;
	}
	public void setdealerSiteCode(String dealerSiteCode) {
		if(dealerSiteCode == null){
			this.dealerSiteCode = "";
		}else {
			this.dealerSiteCode = dealerSiteCode;
		}
		
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDestinationCode() {
		return destinationCode;
	}
	public void setDestinationCode(String destinationCode) {
		if(destinationCode == null){
			this.destinationCode = "";
		}else {
			this.destinationCode = destinationCode;
		}
		
	}
	public String getIntermediateDestinationCode() {
		return intermediateDestinationCode;
	}
	public void setIntermediateDestinationCode(String intermediateDestinationCode) {
		if(intermediateDestinationCode == null){
			this.intermediateDestinationCode = "";
		}else {
			this.intermediateDestinationCode = intermediateDestinationCode;
		}
		
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		if(distance == null){
			this.distance = "";
		}else {
			this.distance = distance;
		}
		
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public AreaGroup getAreaGroup() {
		return areaGroup;
	}
	public void setAreaGroup(AreaGroup areaGroup) {
		this.areaGroup = areaGroup;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getCommonStatusPoint() {
		return commonStatusPoint;
	}
	public void setCommonStatusPoint(String commonStatusPoint) {
		if(commonStatusPoint == null){
			this.commonStatusPoint = "";
		}else {
			this.commonStatusPoint = commonStatusPoint;
		}
		
	}
	
	
	public String getPriceDate() {
		return priceDate;
	}
	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}
	public String getPriceList() {
		return priceList;
	}
	public void setPriceList(String priceList) {
		this.priceList = priceList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null){
			this.name = "";
		}else {
			this.name = name;
		}
		
	}
	public Price getPrice() {
		return Price;
	}
	public void setPrice(Price price) {
		Price = price;
	}


	
	public List<Package> getPackage() {
		return packages;
	}
	@JsonProperty("packages")
	public void setPackage(List<Package> packages) {
		this.packages = packages;
	}
	public String getNoSpecAvailable() {
		return noSpecAvailable;
	}
	@JsonProperty("noSpecsAvailable")
	public void setNoSpecAvailable(String noSpecAvailable) {
		if(noSpecAvailable == null){
			this.noSpecAvailable = "";
		}else {
			this.noSpecAvailable = noSpecAvailable;
		}
		
	}
	public String getLdoc() {
		return ldoc;
	}
	public void setLdoc(String ldoc) {
		if(ldoc == null){
			this.ldoc = "";
		}else {
			this.ldoc = ldoc;
		}
		
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		if(orderType == null){
			this.orderType = "";
		}else {
			this.orderType = orderType;
		}
		
	}
	public String getCommonOrderNumber() {
		return commonOrderNumber;
	}
	public void setCommonOrderNumber(String commonOrderNumber) {
		if(commonOrderNumber == null){
			this.commonOrderNumber = "";
		}else {
			this.commonOrderNumber = commonOrderNumber;
		}
		
	}
	public String getOwnership() {
		return Ownership;
	}
	public void setOwnership(String ownership) {
		if(ownership == null){
			Ownership = "";
		}else {
			Ownership = ownership;
		}
		
	}
	public String getTradeType() {
		return TradeType;
	}
	public void setTradeType(String tradeType) {
		if(tradeType == null){
			TradeType = "";
		}else {
			TradeType = tradeType;
		}
		
	}
	
	public String getIsNscStockCar() {
		return IsNscStockCar;
	}
	public void setIsNscStockCar(String isNscStockCar) {
		if(isNscStockCar == null){
			IsNscStockCar = "";
		}else {
			IsNscStockCar = isNscStockCar;
		}
		
	}
	public DriveLine getDriveline() {
		return driveLineInfo;
	}
	@JsonProperty("driveLineInfo")
	public void setDriveline(DriveLine driveline) {
		this.driveLineInfo = driveline;
	}
	/*public String getAccessories() {
		return Accessories;
	}
	public void setAccessories(String accessories) {
		if(accessories == null){
			Accessories = "";
		}else {
			Accessories = accessories;
		}
		
	}*/
	public String getDealerFittedAccessories() {
		return dealerFittedAccessories;
	}
	public void setDealerFittedAccessories(String dealerFittedAccessories) {
		if(dealerFittedAccessories == null){
			this.dealerFittedAccessories = "";
		}else {
			this.dealerFittedAccessories = dealerFittedAccessories;
		}
		
	}
	public String getEfficiencyClass() {
		return efficiencyClass;
	}
	public void setEfficiencyClass(String efficiencyClass) {
		this.efficiencyClass = efficiencyClass;
	}
	public String getTaxCalcBasedOn() {
		return taxCalcBasedOn;
	}
	public void setTaxCalcBasedOn(String taxCalcBasedOn) {
		if(taxCalcBasedOn == null){
			this.taxCalcBasedOn = "";
		}else {
			this.taxCalcBasedOn = taxCalcBasedOn;
		}
		
	}
	public String getIsWLTP() {
		return IsWLTP;
	}
	public void setIsWLTP(String isWLTP) {
		if(isWLTP == null){
			IsWLTP = "";
		}else {
			IsWLTP = isWLTP;
		}
		
	}
	public String getIsURAX() {
		return IsURAX;
	}
	public void setIsURAX(String isURAX) {
		if(isURAX == null){
			IsURAX = "";
		}else {
			IsURAX = isURAX;
		}
		
	}
	public List<NedcRrcx> getNedcRrcx() {
		return NedcRrcx;
	}
	@JsonProperty("nedcRrcx")
	public void setNedcRrcx(List<NedcRrcx> nedcRrcx) {
		if(nedcRrcx == null){
			NedcRrcx = new ArrayList<>();
		}else{
		NedcRrcx = nedcRrcx;
		}
	}
	public String getWLTPI() {
		return WLTPI;
	}
	
	public void setWLTPI(String wLTPI) {
		if(wLTPI == null){
			WLTPI = "";
		}else {
			WLTPI = wLTPI;
		}
		
	}
	public List<Error> getError() {
		return Error;
	}
	public void setError(List<Error> error) {
		Error = error;
	}
	
	
	public String getCommercialModelYear() {
		return CommercialModelYear;
	}
	public void setCommercialModelYear(String commercialModelYear) {
		if(commercialModelYear == null){
			CommercialModelYear = "";
		}else {
			CommercialModelYear = commercialModelYear;
		}
		
	}
	public CommercialGroup getCommercialGroup() {
		return CommercialGroup;
	}
	public void setCommercialGroup(CommercialGroup commercialGroup) {
		CommercialGroup = commercialGroup;
	}
	public Co2 getCo2() {
		return co2;
	}
	public void setCo2(Co2 co2) {
		this.co2 = co2;
	}
	
	@Override
    public String toString() {
        return "Car [Pno34=" + pno34 + ", Fyon=" + fyon + ", Vin=" + vin+ ", RegistrationNumber=" + registrationNumber + ", ModelYear=" + modelYear + ", StructureWeek=" + structureWeek+ ",DealerSiteCode=" + dealerSiteCode + ", DeliveryDate=" + deliveryDate + ", DestinationCode=" + destinationCode+ ", intermediateDestinationCode=" + intermediateDestinationCode + ", distanceKm=" + distance + ", areaGroup=" + areaGroup+ ",contactInfo=" + contactInfo+ ",CommonStatusPoint=" + commonStatusPoint + ", Package=" + packages + ", HideFeatures=" + HideFeatures+ ", PriceDate=" + priceDate + ", PriceList=" + priceList + ", Name=" + name+ ",Price=" + Price + ",co2=" + co2 + ","
        		+ "NoSpecAvailable=" + noSpecAvailable + ",Ldoc=" + ldoc + ",BrandOrderType=" + orderType + ",OrderNumber=" + commonOrderNumber + ",Ownership=" + Ownership + ",TradeType=" + TradeType + ",CommercialGroup=" + CommercialGroup + ",EfficiencyClass=" + efficiencyClass + ",TaxCalcBasedOn=" + taxCalcBasedOn + ""
        				+ ",IsWLTP=" + IsWLTP + ",IsURAX=" + IsURAX + ",NedcRrcx=" + NedcRrcx + ",Variants=" +Variants+ ", WLTP =" + Wltp +"]";
    }
	public Pno34Std getPno34Std() {
		return pno34Std;
	}
	public void setPno34Std(Pno34Std pno34Std) {
		this.pno34Std = pno34Std;
	}
	
	
	public List<HideFeatures> getHideFeatures() {
		return HideFeatures;
	}
	@JsonProperty("hideFeatures")
	public void setHideFeatures(List<HideFeatures> hideFeatures) {
		HideFeatures = hideFeatures;
	}
	
	public List<Variants> getVariants() {
		return Variants;
	}
	public void setVariants(List<Variants> variants) {
		Variants = variants;
	}
	public List<WLTP> getWltp() {
		return Wltp;
	}
	@JsonProperty("wltp")
	public void setWltp(List<WLTP> wltp) {
		
		Wltp = wltp;
	}
	
	public String getContentStructureWeek() {
		return contentStructureWeek;
	}
	public void setContentStructureWeek(String contentStructureWeek) {
		this.contentStructureWeek = contentStructureWeek;
	}
	
	public String getPartnerGroupId() {
		return PartnerGroupId;
	}
	public void setPartnerGroupId(String partnerGroupId) {
		PartnerGroupId = partnerGroupId;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getUpdatedPrice() {
		return updatedPrice;
	}
	public void setUpdatedPrice(String updatedPrice) {
		this.updatedPrice = updatedPrice;
	}
	public String getIsPriceupdated() {
		return isPriceupdated;
	}
	public void setIsPriceupdated(String isPriceupdated) {
		this.isPriceupdated = isPriceupdated;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getIsUpdatedAllowed() {
		return isUpdatedAllowed;
	}
	@JsonProperty("isUpdateAllowed")
	public void setIsUpdatedAllowed(String isUpdatedAllowed) {
		this.isUpdatedAllowed = isUpdatedAllowed;
	}
	public String getGccPrice() {
		return gccPrice;
	}
	public void setGccPrice(String gccPrice) {
		this.gccPrice = gccPrice;
	}
	public String getAccessoriesConcatenated() {
		return accessoriesConcatenated;
	}
	public void setAccessoriesConcatenated(String accessoriesConcatenated) {
		this.accessoriesConcatenated = accessoriesConcatenated;
	}
	public String getCo2Extrainformation() {
		return co2Extrainformation;
	}
	public void setCo2Extrainformation(String co2Extrainformation) {
		this.co2Extrainformation = co2Extrainformation;
	}
	public String getSelectedFeatureCode() {
		return selectedFeatureCode;
	}
	public void setSelectedFeatureCode(String selectedFeatureCode) {
		this.selectedFeatureCode = selectedFeatureCode;
	}
	public String getPortLocation() {
		return portLocation;
	}
	public void setPortLocation(String portLocation) {
		this.portLocation = portLocation;
	}
	public String getModelCode() {
		return ModelCode;
	}
	public void setModelCode(String modelCode) {
		ModelCode = modelCode;
	}
	public String getIsReda() {
		return IsReda;
	}
	public void setIsReda(String isReda) {
		IsReda = isReda;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getShowBasicPrice() {
		return showBasicPrice;
	}
	public void setShowBasicPrice(String showBasicPrice) {
		this.showBasicPrice = showBasicPrice;
	}
	public String getTaxationDate() {
		return taxationDate;
	}
	public void setTaxationDate(String taxationDate) {
		this.taxationDate = taxationDate;
	}
	public DriveLine getDriveLineInfo() {
		return driveLineInfo;
	}
	public void setDriveLineInfo(DriveLine driveLineInfo) {
		this.driveLineInfo = driveLineInfo;
	}
	/*public Weight getWeight() {
		return weight;
	}
	public void setWeight(Weight weight) {
		this.weight = weight;
	}*/
	public String getEndOfSeries() {
		return endOfSeries;
	}
	public void setEndOfSeries(String endOfSeries) {
		this.endOfSeries = endOfSeries;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
		
}
