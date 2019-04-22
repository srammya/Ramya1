package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the NEDC database table.
 * 
 */
@Entity
@Table(name="NEDC")
@NamedQuery(name="Nedc.findAll", query="SELECT n FROM Nedc n")
public class Nedc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Nedc_ID")
	private int nedc_ID;

	@Column(name="NEDC_Description")
	private String NEDC_Description;

	@Column(name="Nedc_RedaName")
	private String NEDC_RedaName;

	@Column(name="Nedc_Type")
	private String NEDC_Type;

	@Column(name="Nedc_Unit")
	private String NEDC_Unit;

	@Column(name="Nedc_Value")
	private String NEDC_Value;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public Nedc() {
	}

	public int getNedc_ID() {
		return this.nedc_ID;
	}

	public void setNedc_ID(int nedc_ID) {
		this.nedc_ID = nedc_ID;
	}

	public String getNEDC_Description() {
		return this.NEDC_Description;
	}

	public void setNEDC_Description(String NEDC_Description) {
		this.NEDC_Description = NEDC_Description;
	}

	public String getNEDC_RedaName() {
		return this.NEDC_RedaName;
	}

	public void setNEDC_RedaName(String NEDC_RedaName) {
		this.NEDC_RedaName = NEDC_RedaName;
	}

	public String getNEDC_Type() {
		return this.NEDC_Type;
	}

	public void setNEDC_Type(String NEDC_Type) {
		this.NEDC_Type = NEDC_Type;
	}

	public String getNEDC_Unit() {
		return this.NEDC_Unit;
	}

	public void setNEDC_Unit(String NEDC_Unit) {
		this.NEDC_Unit = NEDC_Unit;
	}

	public String getNEDC_Value() {
		return this.NEDC_Value;
	}

	public void setNEDC_Value(String NEDC_Value) {
		this.NEDC_Value = NEDC_Value;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}