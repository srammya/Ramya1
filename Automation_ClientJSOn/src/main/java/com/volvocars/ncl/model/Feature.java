package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.engine.profile.Fetch;


/**
 * The persistent class for the FEATURES database table.
 * 
 */
@Entity
@Table(name="dbo.FEATURES")
@NamedQuery(name="Feature.findAll", query="SELECT f FROM Feature f")
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Feature_Id", unique=true, nullable=false)
	private int feature_Id;

	@Column(name="Feature_Code", nullable=false)
	private String feature_Code;

	@Column(name="Feature_Description", nullable=false)
	private String feature_Description;

	@Column(name="Model_Year", nullable=false)
	private int model_Year;
	
	@Column(name="Feature_Name", nullable=false)
	private String feature_Name;

	//bi-directional many-to-one association to TypeMaster
	@JoinColumn(name="Type", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private TypeMaster typeMaster;

	public Feature() {
	}

	public int getFeature_Id() {
		return this.feature_Id;
	}

	public void setFeature_Id(int feature_Id) {
		this.feature_Id = feature_Id;
	}

	public String getFeature_Code() {
		return this.feature_Code;
	}

	public void setFeature_Code(String feature_Code) {
		this.feature_Code = feature_Code;
	}

	public String getFeature_Description() {
		return this.feature_Description;
	}

	public void setFeature_Description(String feature_Description) {
		this.feature_Description = feature_Description;
	}

	public int getModel_Year() {
		return this.model_Year;
	}

	public void setModel_Year(int model_Year) {
		this.model_Year = model_Year;
	}
	
	public String getFeature_Name() {
		return this.feature_Name;
	}

	public void setFeature_Name(String feature_Name) {
		this.feature_Name = feature_Name;
	}

	public TypeMaster getTypeMaster() {
		return this.typeMaster;
	}

	public void setTypeMaster(TypeMaster typeMaster) {
		this.typeMaster = typeMaster;
	}
	
	

}