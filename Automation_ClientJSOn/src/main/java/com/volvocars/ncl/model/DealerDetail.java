package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEALER_DETAILS database table.
 * 
 */
@Entity
@Table(name="DEALER_DETAILS")
@NamedQuery(name="DealerDetail.findAll", query="SELECT d FROM DealerDetail d")
public class DealerDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DealerDetailsNo")
	private int dealerDetailsNo;

	@Column(name="DealerCode")
	private String dealerCode;

	@Column(name="Ownership")
	private String ownership;

	@Column(name="PartnerID")
	private String partnerID;

	//bi-directional many-to-one association to Car
	@JoinColumn(name="Fyon", nullable = false)
	@ManyToOne
	private Car car;

	public DealerDetail() {
	}

	public int getDealerDetailsNo() {
		return this.dealerDetailsNo;
	}

	public void setDealerDetailsNo(int dealerDetailsNo) {
		this.dealerDetailsNo = dealerDetailsNo;
	}

	public String getDealerCode() {
		return this.dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getOwnership() {
		return this.ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getPartnerID() {
		return this.partnerID;
	}

	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}