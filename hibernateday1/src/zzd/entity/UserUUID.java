package zzd.entity;

public class UserUUID {
	private String uid;
	private String username;
	private String password;
	private String address;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserUUID [uid=" + uid + ", username=" + username + ", password=" + password + ", address=" + address
				+ "]";
	}
}
