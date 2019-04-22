package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PRICE database table.
 * 
 */
@Entity
@Table(name="PRICE")
@NamedQuery(name="Price.findAll", query="SELECT p FROM Price p")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRICE_NO")
	private int priceNo;

	@Column(name="Basic_Price_Name")
	private String basic_Price_Name;

	@Column(name="Basic_Price_Value")
	private String basic_Price_Value;

	@Column(name="Currency")
	private String currency;

	@Column(name="Delivery_Charge_Name")
	private String delivery_Charge_Name;

	@Column(name="Delivery_Charge_Value")
	private String delivery_Charge_Value;

	@Column(name="Retail_Price_Before_Tax_Name")
	private String retail_Price_Before_Tax_Name;

	@Column(name="Retail_Price_Before_Tax_Value")
	private String retail_Price_Before_Tax_Value;

	@Column(name="Tax1_Name")
	private String tax1_Name;

	@Column(name="Tax1_Value")
	private String tax1_Value;

	@Column(name="Tax2_Name")
	private String tax2_Name;

	@Column(name="Tax2_Value")
	private String tax2_Value;

	@Column(name="Tax3_Name")
	private String tax3_Name;

	@Column(name="Tax3_Value")
	private String tax3_Value;

	@Column(name="Tax4_Name")
	private String tax4_Name;

	@Column(name="Tax4_Value")
	private String tax4_Value;

	@Column(name="Total_Price_Name")
	private String total_Price_Name;

	@Column(name="Total_Price_Value")
	private String total_Price_Value;

	@Column(name="Total_Tax_Amount")
	private String total_Tax_Amount;

	@Column(name="Total_VATAmt_Name")
	private String total_VATAmt_Name;

	@Column(name="Total_VATAmt_Value")
	private String total_VATAmt_Value;

	@Column(name="Urax_Tax_Id")
	private String urax_Tax_Id;

	@Column(name="Urax_Tax_Name")
	private String urax_Tax_Name;

	@Column(name="Urax_Tax_Value")
	private String urax_Tax_Value;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public Price() {
	}

	public int getPriceNo() {
		return this.priceNo;
	}

	public void setPriceNo(int priceNo) {
		this.priceNo = priceNo;
	}

	public String getBasic_Price_Name() {
		return this.basic_Price_Name;
	}

	public void setBasic_Price_Name(String basic_Price_Name) {
		this.basic_Price_Name = basic_Price_Name;
	}

	public String getBasic_Price_Value() {
		return this.basic_Price_Value;
	}

	public void setBasic_Price_Value(String basic_Price_Value) {
		this.basic_Price_Value = basic_Price_Value;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDelivery_Charge_Name() {
		return this.delivery_Charge_Name;
	}

	public void setDelivery_Charge_Name(String delivery_Charge_Name) {
		this.delivery_Charge_Name = delivery_Charge_Name;
	}

	public String getDelivery_Charge_Value() {
		return this.delivery_Charge_Value;
	}

	public void setDelivery_Charge_Value(String delivery_Charge_Value) {
		this.delivery_Charge_Value = delivery_Charge_Value;
	}

	public String getRetail_Price_Before_Tax_Name() {
		return this.retail_Price_Before_Tax_Name;
	}

	public void setRetail_Price_Before_Tax_Name(String retail_Price_Before_Tax_Name) {
		this.retail_Price_Before_Tax_Name = retail_Price_Before_Tax_Name;
	}

	public String getRetail_Price_Before_Tax_Value() {
		return this.retail_Price_Before_Tax_Value;
	}

	public void setRetail_Price_Before_Tax_Value(String retail_Price_Before_Tax_Value) {
		this.retail_Price_Before_Tax_Value = retail_Price_Before_Tax_Value;
	}

	public String getTax1_Name() {
		return this.tax1_Name;
	}

	public void setTax1_Name(String tax1_Name) {
		this.tax1_Name = tax1_Name;
	}

	public String getTax1_Value() {
		return this.tax1_Value;
	}

	public void setTax1_Value(String tax1_Value) {
		this.tax1_Value = tax1_Value;
	}

	public String getTax2_Name() {
		return this.tax2_Name;
	}

	public void setTax2_Name(String tax2_Name) {
		this.tax2_Name = tax2_Name;
	}

	public String getTax2_Value() {
		return this.tax2_Value;
	}

	public void setTax2_Value(String tax2_Value) {
		this.tax2_Value = tax2_Value;
	}

	public String getTax3_Name() {
		return this.tax3_Name;
	}

	public void setTax3_Name(String tax3_Name) {
		this.tax3_Name = tax3_Name;
	}

	public String getTax3_Value() {
		return this.tax3_Value;
	}

	public void setTax3_Value(String tax3_Value) {
		this.tax3_Value = tax3_Value;
	}

	public String getTax4_Name() {
		return this.tax4_Name;
	}

	public void setTax4_Name(String tax4_Name) {
		this.tax4_Name = tax4_Name;
	}

	public String getTax4_Value() {
		return this.tax4_Value;
	}

	public void setTax4_Value(String tax4_Value) {
		this.tax4_Value = tax4_Value;
	}

	public String getTotal_Price_Name() {
		return this.total_Price_Name;
	}

	public void setTotal_Price_Name(String total_Price_Name) {
		this.total_Price_Name = total_Price_Name;
	}

	public String getTotal_Price_Value() {
		return this.total_Price_Value;
	}

	public void setTotal_Price_Value(String total_Price_Value) {
		this.total_Price_Value = total_Price_Value;
	}

	public String getTotal_Tax_Amount() {
		return this.total_Tax_Amount;
	}

	public void setTotal_Tax_Amount(String total_Tax_Amount) {
		this.total_Tax_Amount = total_Tax_Amount;
	}

	public String getTotal_VATAmt_Name() {
		return this.total_VATAmt_Name;
	}

	public void setTotal_VATAmt_Name(String total_VATAmt_Name) {
		this.total_VATAmt_Name = total_VATAmt_Name;
	}

	public String getTotal_VATAmt_Value() {
		return this.total_VATAmt_Value;
	}

	public void setTotal_VATAmt_Value(String total_VATAmt_Value) {
		this.total_VATAmt_Value = total_VATAmt_Value;
	}

	public String getUrax_Tax_Id() {
		return this.urax_Tax_Id;
	}

	public void setUrax_Tax_Id(String urax_Tax_Id) {
		this.urax_Tax_Id = urax_Tax_Id;
	}

	public String getUrax_Tax_Name() {
		return this.urax_Tax_Name;
	}

	public void setUrax_Tax_Name(String urax_Tax_Name) {
		this.urax_Tax_Name = urax_Tax_Name;
	}

	public String getUrax_Tax_Value() {
		return this.urax_Tax_Value;
	}

	public void setUrax_Tax_Value(String urax_Tax_Value) {
		this.urax_Tax_Value = urax_Tax_Value;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}