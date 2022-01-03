package kr.green.khl.vo;
//테이블을 VO로 만들어야함
public class MemberVO {
	
	private String id;
	private String pw;
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + "]";
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

}
