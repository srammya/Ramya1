package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CAR_GROUP database table.
 * 
 */
@Entity
@Table(name="CAR_GROUP")
@NamedQuery(name="CarGroup.findAll", query="SELECT c FROM CarGroup c")
public class CarGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Group_No", unique=true, nullable=false)
	private int group_No;

	@Column(name="Feature_Code")
	private String feature_Code;

	@Column(name="Feature_Type")
	private int feature_Type;

	@Column(name="Feature_Type_Group_Id")
	private int feature_Type_Group_Id;

	@Column(name="Feature_Type_Group_Name")
	private String feature_Type_Group_Name;

	@Column(name="Group_Id")
	private String group_Id;

	@Column(name="Group_Name")
	private String group_Name;

	public CarGroup() {
	}

	public int getGroup_No() {
		return this.group_No;
	}

	public void setGroup_No(int group_No) {
		this.group_No = group_No;
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

	public int getFeature_Type_Group_Id() {
		return this.feature_Type_Group_Id;
	}

	public void setFeature_Type_Group_Id(int feature_Type_Group_Id) {
		this.feature_Type_Group_Id = feature_Type_Group_Id;
	}

	public String getFeature_Type_Group_Name() {
		return this.feature_Type_Group_Name;
	}

	public void setFeature_Type_Group_Name(String feature_Type_Group_Name) {
		this.feature_Type_Group_Name = feature_Type_Group_Name;
	}

	public String getGroup_Id() {
		return this.group_Id;
	}

	public void setGroup_Id(String group_Id) {
		this.group_Id = group_Id;
	}

	public String getGroup_Name() {
		return this.group_Name;
	}

	public void setGroup_Name(String group_Name) {
		this.group_Name = group_Name;
	}

}