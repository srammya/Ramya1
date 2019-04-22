package com.volvocars.ncl.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPE_MASTER database table.
 * 
 */
@Entity
@Table(name="TYPE_MASTER")
@NamedQuery(name="TypeMaster.findAll", query="SELECT t FROM TypeMaster t")
public class TypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Type", unique=true, nullable=false)
	private int type;

	@Column(name="Type_Id", nullable=false)
	private int type_Id;

	@Column(name="Type_Name", nullable=false)
	private String type_Name;

	//bi-directional many-to-one association to Feature
	@OneToMany(mappedBy="typeMaster")
	private List<Feature> features;

	public TypeMaster() {
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType_Id() {
		return this.type_Id;
	}

	public void setType_Id(int type_Id) {
		this.type_Id = type_Id;
	}

	public String getType_Name() {
		return this.type_Name;
	}

	public void setType_Name(String type_Name) {
		this.type_Name = type_Name;
	}

	public List<Feature> getFeatures() {
		return this.features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public Feature addFeature(Feature feature) {
		getFeatures().add(feature);
		feature.setTypeMaster(this);

		return feature;
	}

	public Feature removeFeature(Feature feature) {
		getFeatures().remove(feature);
		feature.setTypeMaster(null);

		return feature;
	}

}