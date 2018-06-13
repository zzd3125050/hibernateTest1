package zzd.entity;

public class Customer {
	private Integer cid;
	private String cName;
	private String cLevel;
	private String cSource;
	private String cPhone;
	private String cMobile;
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cName=" + cName + ", cLevel=" + cLevel + ", cSource=" + cSource + ", cphone="
				+ cPhone + ", cMobile=" + cMobile + "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcLevel() {
		return cLevel;
	}
	public void setcLevel(String cLevel) {
		this.cLevel = cLevel;
	}
	public String getcSource() {
		return cSource;
	}
	public void setcSource(String cSource) {
		this.cSource = cSource;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String getcMobile() {
		return cMobile;
	}
	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}
	
}
