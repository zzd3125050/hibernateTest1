package zzd.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer cid;
	private String cName;
	private String cLevel;
	private String cSource;//来源
	private String cPhone;
	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();
	
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
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
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cName=" + cName + ", cLevel=" + cLevel + ", cSource=" + cSource + ", cPhone="
				+ cPhone + "]";
	}
	
}
