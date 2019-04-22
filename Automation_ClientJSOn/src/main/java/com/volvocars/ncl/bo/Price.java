package com.volvocars.ncl.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tmohamed
 *
 */
public class Price {
	private String currency;
	private BasicPrice BasicPrice = new  BasicPrice();
	private DeliveryCharge DeliveryCharge = new DeliveryCharge();
	private RetailPriceBeforeTax RetailPriceBeforeTax = new  RetailPriceBeforeTax();
	private Tax1 Tax1 = new Tax1();
	private Tax2 Tax2 = new Tax2();
	private Tax3 Tax3 = new Tax3();
	private Tax4 Tax4 = new Tax4();
	private TotalPrice TotalPrice = new TotalPrice();
	private String totalTaxAmount;
	private String totalTaxes;
	private TotalVATAmount TotalVATAmount = new TotalVATAmount();
	private List<UraxTaxes> UraxTaxes = new ArrayList<UraxTaxes>();
	private String AccessoriesPrice;
	//private UraxTaxes uraxTaxes = new UraxTaxes();
		
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String Currency) {
		currency = Currency;
	}
	public BasicPrice getBasicPrice() {
		return BasicPrice;
	}
	public void setBasicPrice(BasicPrice basicPrice) {
		BasicPrice = basicPrice;
	}
	
	public RetailPriceBeforeTax getRetailPriceBeforeTax() {
		return RetailPriceBeforeTax;
	}
	public void setRetailPriceBeforeTax(RetailPriceBeforeTax retailPriceBeforeTax) {
		RetailPriceBeforeTax = retailPriceBeforeTax;
	}
	
	public TotalPrice getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(TotalPrice totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getTotalTaxAmount() {
		return totalTaxAmount;
	}
	public void setTotalTaxAmount(String TotalTaxAmount) {
		totalTaxAmount = TotalTaxAmount;
	}
	public List<UraxTaxes> getUraxTaxes() {
		return UraxTaxes;
	}
	public void setUraxTaxes(List<UraxTaxes> uraxTaxes) {
		UraxTaxes = uraxTaxes;
	}
	
	public TotalVATAmount getTotalVATAmount(){
		return TotalVATAmount;
		
	}
	
	public void setTotalVATAmount(TotalVATAmount toalVATAmount){
		TotalVATAmount = toalVATAmount;
	}

	@Override
    public String toString() {
        return "[Currency=" + currency + ", BasicPrice=" + BasicPrice + ", DeliveryCharge=" + DeliveryCharge+ ", RetailPriceBeforeTax=" + RetailPriceBeforeTax + ", Tax1=" + Tax1 + ", Tax2=" + Tax2+ ",Tax3=" + Tax3 + ", Tax4=" + Tax4 + ", TotalPrice=" + TotalPrice+ ", TotalTaxAmount=" + totalTaxAmount + ", UraxTaxes=" + UraxTaxes + ", TotalVATAmount=" +TotalVATAmount+ "]";
    }
	public DeliveryCharge getDeliveryCharge() {
		return DeliveryCharge;
	}
	public void setDeliveryCharge(DeliveryCharge deliveryCharge) {
		DeliveryCharge = deliveryCharge;
	}
	public Tax1 getTax1() {
		return Tax1;
	}
	public void setTax1(Tax1 tax1) {
		Tax1 = tax1;
	}
	public Tax2 getTax2() {
		return Tax2;
	}
	public void setTax2(Tax2 tax2) {
		Tax2 = tax2;
	}
	public Tax3 getTax3() {
		return Tax3;
	}
	public void setTax3(Tax3 tax3) {
		Tax3 = tax3;
	}
	public Tax4 getTax4() {
		return Tax4;
	}
	public void setTax4(Tax4 tax4) {
		Tax4 = tax4;
	}
	
	public String getAccessoriesPrice() {
		return AccessoriesPrice;
	}
	public void setAccessoriesPrice(String accessoriesPrice) {
		AccessoriesPrice = accessoriesPrice;
	}
	public String getTotalTaxes() {
		return totalTaxes;
	}
	public void setTotalTaxes(String totalTaxes) {
		this.totalTaxes = totalTaxes;
	}
	
}
