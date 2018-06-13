package zzd.entity;

public class Cust {
	private Integer cid;
	private String name;
	private String level;
	private String source;
	private String phone;
	private String mobile;
	private String cC;

	public String getcC() {
		return cC;
	}
	public void setcC(String cC) {
		this.cC = cC;
	}
	@Override
	public String toString() {
		return "Cust [cid=" + cid + ", name=" + name + ", level=" + level + ", source=" + source + ", phone=" + phone
				+ ", mobile=" + mobile + ", cC=" + cC + "]";
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}	
}
