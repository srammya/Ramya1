package com.volvocars.ncl.bo;

public class DriveLine {

	private String driveLineId;
	private String co2Emission;
	private String driveLineDescription;
	private String efficiencyClass;
	private String fuelConsumption;
	public String getDriveLineId() {
		return driveLineId;
	}
	public void setDriveLineId(String driveLineId) {
		this.driveLineId = driveLineId;
	}
	public String getCo2Emission() {
		return co2Emission;
	}
	public void setCo2Emission(String co2Emission) {
		this.co2Emission = co2Emission;
	}
	public String getDriveLineDescription() {
		return driveLineDescription;
	}
	public void setDriveLineDescription(String driveLineDescription) {
		this.driveLineDescription = driveLineDescription;
	}
	public String getEfficiencyClass() {
		return efficiencyClass;
	}
	public void setEfficiencyClass(String efficiencyClass) {
		this.efficiencyClass = efficiencyClass;
	}
	public String getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(String fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	@Override
    public String toString() {
        return "[driveLineId=" + driveLineId + ",co2Emission=" + co2Emission + ", driveLineDescription=" + driveLineDescription + ", efficiencyClass=" + efficiencyClass + ",fuelConsumption= "+ fuelConsumption+ "]";
    }
}
