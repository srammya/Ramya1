package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OPTIONS_FEATURE_CODE database table.
 * 
 */
@Entity
@Table(name="OPTIONS_FEATURE_CODE")
@NamedQuery(name="OptionsFeatureCode.findAll", query="SELECT o FROM OptionsFeatureCode o")
public class OptionsFeatureCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Option_Featurecode_No")
	private int option_Featurecode_No;

	@Column(name="Option_Feature_Code")
	private String option_Feature_Code;

	//bi-directional many-to-one association to Car
	@ManyToOne
	@JoinColumn(name="FYON")
	private Car car;

	public OptionsFeatureCode() {
	}

	public int getOption_Featurecode_No() {
		return this.option_Featurecode_No;
	}

	public void setOption_Featurecode_No(int option_Featurecode_No) {
		this.option_Featurecode_No = option_Featurecode_No;
	}

	public String getOption_Feature_Code() {
		return this.option_Feature_Code;
	}

	public void setOption_Feature_Code(String option_Feature_Code) {
		this.option_Feature_Code = option_Feature_Code;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}