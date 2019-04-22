package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEALER_INFO database table.
 * 
 */
@Entity
@Table(name="DEALER_INFO")
@NamedQuery(name="DealerInfo.findAll", query="SELECT d FROM DealerInfo d")
public class DealerInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Dealerinfo_No")
	private int dealerinfo_No;

	@Column(name="Area_Group_Id")
	private String area_Group_Id;

	@Column(name="Dealer_Code")
	private String dealer_Code;

	@Column(name="Partner_Group_Id")
	private String partner_Group_Id;

	//bi-directional many-to-one association to Car
	@JoinColumn(name="FYON")
	@ManyToOne
	private Car car;

	public DealerInfo() {
	}

	public int getDealerinfo_No() {
		return this.dealerinfo_No;
	}

	public void setDealerinfo_No(int dealerinfo_No) {
		this.dealerinfo_No = dealerinfo_No;
	}

	public String getArea_Group_Id() {
		return this.area_Group_Id;
	}

	public void setArea_Group_Id(String area_Group_Id) {
		this.area_Group_Id = area_Group_Id;
	}

	public String getDealer_Code() {
		return this.dealer_Code;
	}

	public void setDealer_Code(String dealer_Code) {
		this.dealer_Code = dealer_Code;
	}

	public String getPartner_Group_Id() {
		return this.partner_Group_Id;
	}

	public void setPartner_Group_Id(String partner_Group_Id) {
		this.partner_Group_Id = partner_Group_Id;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}