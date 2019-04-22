package com.volvocars.ncl.bo;

/**
 * @author tmohamed
 *
 */
public class CommercialGroup {
	private String PartnerGroupId;
	private String Description;
	
	public String getPartnerGroupId() {
		return PartnerGroupId;
	}
	public void setPartnerGroupId(String partnerGroupId) {
		PartnerGroupId = partnerGroupId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
    public String toString() {
        return "[PartnerGroupId=" + PartnerGroupId + ", Description=" + Description + "]";
    }
}
