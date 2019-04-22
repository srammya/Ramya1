package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="WLTP")
@NamedQuery(name="Wltp.findAll", query="SELECT w FROM Wltp w")
public class Wltp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Wltp_ID")
	private int wltp_ID;

	@Column(name="Wltp_Description")
	private String WLTP_Description;

	@Column(name="Wltp_Name")
	private String WLTP_Name;

	@Column(name="Wltp_RedaName")
	private String WLTP_RedaName;

	@Column(name="Wltp_Unit")
	private String WLTP_Unit;
	
	@Column(name="Wltp_Value")
	private String WLTP_Value;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public Wltp() {
	}

	public int getWltp_ID() {
		return this.wltp_ID;
	}

	public void setWltp_ID(int wltp_ID) {
		this.wltp_ID = wltp_ID;
	}

	public Object getWLTP_Description() {
		return this.WLTP_Description;
	}


	public String getWLTP_Name() {
		return WLTP_Name;
	}

	public void setWLTP_Name(String wLTP_Name) {
		WLTP_Name = wLTP_Name;
	}

	public String getWLTP_RedaName() {
		return WLTP_RedaName;
	}

	public void setWLTP_RedaName(String wLTP_RedaName) {
		WLTP_RedaName = wLTP_RedaName;
	}

	public String getWLTP_Unit() {
		return WLTP_Unit;
	}

	public void setWLTP_Unit(String wLTP_Unit) {
		WLTP_Unit = wLTP_Unit;
	}

	public String getWLTP_Value() {
		return WLTP_Value;
	}

	public void setWLTP_Value(String wLTP_Value) {
		WLTP_Value = wLTP_Value;
	}

	public void setWLTP_Description(String wLTP_Description) {
		WLTP_Description = wLTP_Description;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}