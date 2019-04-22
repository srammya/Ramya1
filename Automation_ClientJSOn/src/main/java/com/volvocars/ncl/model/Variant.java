package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the VARIANTS database table.
 * 
 */
@Entity
@Table(name="VARIANTS")
@NamedQuery(name="Variant.findAll", query="SELECT v FROM Variant v")
public class Variant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Variant_ID")
	private int variant_ID;

	@Column(name="Variant_Description")
	private String variant_Description;

	@Column(name="Variant_FeatureCode")
	private String variant_FeatureCode;

	@Column(name="Variant_ModelYear")
	private String variant_ModelYear;

	@Column(name="Variant_Name")
	private String variant_Name;

	@Column(name="Variant_Type")
	private int variant_Type;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public Variant() {
	}

	public int getVariant_ID() {
		return this.variant_ID;
	}

	public void setVariant_ID(int variant_ID) {
		this.variant_ID = variant_ID;
	}

	public String getVariant_Description() {
		return this.variant_Description;
	}

	public void setVariant_Description(String variant_Description) {
		this.variant_Description = variant_Description;
	}

	public String getVariant_FeatureCode() {
		return this.variant_FeatureCode;
	}

	public void setVariant_FeatureCode(String variant_FeatureCode) {
		this.variant_FeatureCode = variant_FeatureCode;
	}

	public String getVariant_ModelYear() {
		return this.variant_ModelYear;
	}

	public void setVariant_ModelYear(String variant_ModelYear) {
		this.variant_ModelYear = variant_ModelYear;
	}

	public String getVariant_Name() {
		return this.variant_Name;
	}

	public void setVariant_Name(String variant_Name) {
		this.variant_Name = variant_Name;
	}

	public int getVariant_Type() {
		return this.variant_Type;
	}

	public void setVariant_Type(int variant_Type) {
		this.variant_Type = variant_Type;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}