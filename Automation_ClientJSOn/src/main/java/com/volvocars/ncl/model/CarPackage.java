package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CAR_PACKAGE database table.
 * 
 */
@Entity
@Table(name="CAR_PACKAGE")
@NamedQuery(name="CarPackage.findAll", query="SELECT c FROM CarPackage c")
public class CarPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PACKAGE_NO")
	private int packageNo;

	@Column(name="Feature_Code")
	private String feature_Code;

	@Column(name="Feature_Type")
	private int feature_Type;

	@Column(name="Package_Code")
	private String package_Code;

	@Column(name="Package_Name")
	private String package_Name;

	@Column(name="Package_Type")
	private int package_Type;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public CarPackage() {
	}

	public int getPackageNo() {
		return this.packageNo;
	}

	public void setPackageNo(int packageNo) {
		this.packageNo = packageNo;
	}

	public String getFeature_Code() {
		return this.feature_Code;
	}

	public void setFeature_Code(String feature_Code) {
		this.feature_Code = feature_Code;
	}

	public int getFeature_Type() {
		return this.feature_Type;
	}

	public void setFeature_Type(int feature_Type) {
		this.feature_Type = feature_Type;
	}

	public String getPackage_Code() {
		return this.package_Code;
	}

	public void setPackage_Code(String package_Code) {
		this.package_Code = package_Code;
	}

	public String getPackage_Name() {
		return this.package_Name;
	}

	public void setPackage_Name(String package_Name) {
		this.package_Name = package_Name;
	}

	public int getPackage_Type() {
		return this.package_Type;
	}

	public void setPackage_Type(int package_Type) {
		this.package_Type = package_Type;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}