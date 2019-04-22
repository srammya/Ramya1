package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the DRIVELINE database table.
 * 
 */
@Entity
@Table(name="DRIVELINE")
@NamedQuery(name="Driveline.findAll", query="SELECT d FROM Driveline d")
public class Driveline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Driveline_No")
	private int driveline_No;

	@Column(name="CO2_Emission")
	private String CO2_Emission;

	@Column(name="DriveLine_Description")
	private String driveLine_Description;

	@Column(name="DriveLine_Id")
	private int driveLine_Id;

	@Column(name="Efficiency_Class")
	private String efficiency_Class;

	@Column(name="Fuel_Consumption")
	private String fuel_Consumption;

	//bi-directional many-to-one association to Car
	@JoinColumn(name="FYON")
	@ManyToOne
	private Car car;

	public Driveline() {
	}

	public int getDriveline_No() {
		return this.driveline_No;
	}

	public void setDriveline_No(int driveline_No) {
		this.driveline_No = driveline_No;
	}

	public String getCO2_Emission() {
		return this.CO2_Emission;
	}

	public void setCO2_Emission(String CO2_Emission) {
		this.CO2_Emission = CO2_Emission;
	}

	public String getDriveLine_Description() {
		return this.driveLine_Description;
	}

	public void setDriveLine_Description(String driveLine_Description) {
		this.driveLine_Description = driveLine_Description;
	}

	public int getDriveLine_Id() {
		return this.driveLine_Id;
	}

	public void setDriveLine_Id(int driveLine_Id) {
		this.driveLine_Id = driveLine_Id;
	}

	public String getEfficiency_Class() {
		return this.efficiency_Class;
	}

	public void setEfficiency_Class(String efficiency_Class) {
		this.efficiency_Class = efficiency_Class;
	}

	public String getFuel_Consumption() {
		return this.fuel_Consumption;
	}

	public void setFuel_Consumption(String fuel_Consumption) {
		this.fuel_Consumption = fuel_Consumption;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}