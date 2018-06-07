package zzd.entity;

public class LinkMan {
	private Integer lid;
	private String lName;
	private String lGender;
	private String lPhone;
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlGender() {
		return lGender;
	}
	public void setlGender(String lGender) {
		this.lGender = lGender;
	}
	public String getlPhone() {
		return lPhone;
	}
	public void setlPhone(String lPhone) {
		this.lPhone = lPhone;
	}
	@Override
	public String toString() {
		return "LinkMan [lid=" + lid + ", lName=" + lName + ", lGender=" + lGender + ", lPhone=" + lPhone + "]";
	}
	
}
