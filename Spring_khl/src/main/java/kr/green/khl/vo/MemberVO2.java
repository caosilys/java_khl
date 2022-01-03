package kr.green.khl.vo;
//테이블을 VO로 만들어야함
public class MemberVO2 {
	
	private String id;
	private String pw;
	private String pw2;
	private String name;
	private String birth;
	private String gender;
	private String postcode;
	@Override
	public String toString() {
		return "MemberVO2 [id=" + id + ", pw=" + pw + ", pw2=" + pw2 + ", name=" + name + ", birth=" + birth
				+ ", gender=" + gender + ", postcode=" + postcode + ", address=" + address + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String address;
	
}
