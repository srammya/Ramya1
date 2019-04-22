package com.volvocars.ncl.bo;

/**
 * @author tmohamed
 *
 */
public class ContactInfo {
	private String name;
	private String phone;
	private String email;
	private String info;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ContactInfo [name=" + name + ", phone=" + phone + ", email=" + email + ", info=" + info + ", value="
				+ value + "]";
	}
	
}
