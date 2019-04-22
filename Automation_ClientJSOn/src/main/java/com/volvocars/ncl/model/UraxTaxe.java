package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the URAX_TAXES database table.
 * 
 */
@Entity
@Table(name="URAX_TAXES")
@NamedQuery(name="UraxTaxe.findAll", query="SELECT u FROM UraxTaxe u")
public class UraxTaxe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="URAX_NO")
	private int uraxNo;

	@Column(name="Charge_Items")
	private String charge_Items;

	@Column(name="Constant_Name")
	private String constant_Name;

	@Column(name="Currency")
	private String currency;

	@Column(name="Price")
	private int price;

	@Column(name="Price_WO_VAT")
	private int price_WO_VAT;

	@Column(name="Tax_Id")
	private String tax_Id;

	@Column(name="Tax_Name")
	private String tax_Name;

	@Column(name="Tax_Value")
	private String tax_Value;

	@Column(name="Tax_Version")
	private String tax_Version;

	@Column(name="VAT_Position")
	private String VAT_Position;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public UraxTaxe() {
	}

	public int getUraxNo() {
		return this.uraxNo;
	}

	public void setUraxNo(int uraxNo) {
		this.uraxNo = uraxNo;
	}

	public String getCharge_Items() {
		return this.charge_Items;
	}

	public void setCharge_Items(String charge_Items) {
		this.charge_Items = charge_Items;
	}

	public String getConstant_Name() {
		return this.constant_Name;
	}

	public void setConstant_Name(String constant_Name) {
		this.constant_Name = constant_Name;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice_WO_VAT() {
		return this.price_WO_VAT;
	}

	public void setPrice_WO_VAT(int price_WO_VAT) {
		this.price_WO_VAT = price_WO_VAT;
	}

	public String getTax_Id() {
		return this.tax_Id;
	}

	public void setTax_Id(String tax_Id) {
		this.tax_Id = tax_Id;
	}

	public String getTax_Name() {
		return this.tax_Name;
	}

	public void setTax_Name(String tax_Name) {
		this.tax_Name = tax_Name;
	}

	public String getTax_Value() {
		return this.tax_Value;
	}

	public void setTax_Value(String tax_Value) {
		this.tax_Value = tax_Value;
	}

	public String getTax_Version() {
		return this.tax_Version;
	}

	public void setTax_Version(String tax_Version) {
		this.tax_Version = tax_Version;
	}

	public String getVAT_Position() {
		return this.VAT_Position;
	}

	public void setVAT_Position(String VAT_Position) {
		this.VAT_Position = VAT_Position;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}