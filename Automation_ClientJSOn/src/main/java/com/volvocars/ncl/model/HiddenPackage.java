package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the HIDDEN_PACKAGE database table.
 * 
 */
@Entity
@Table(name="HIDDEN_PACKAGE")
@NamedQuery(name="HiddenPackage.findAll", query="SELECT h FROM HiddenPackage h")
public class HiddenPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Hidden_Package_No")
	private int hidden_Package_No;

	@Column(name="Feature_Code")
	private String feature_Code;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public HiddenPackage() {
	}

	public int getHidden_Package_No() {
		return this.hidden_Package_No;
	}

	public void setHidden_Package_No(int hidden_Package_No) {
		this.hidden_Package_No = hidden_Package_No;
	}

	public String getFeature_Code() {
		return this.feature_Code;
	}

	public void setFeature_Code(String feature_Code) {
		this.feature_Code = feature_Code;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}