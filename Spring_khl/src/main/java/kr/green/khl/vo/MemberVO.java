package kr.green.khl.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

//테이블을 VO로 만들어야함
@Data
public class MemberVO {
	
	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_gender;
	private Date me_birth;
	private String me_address;
	private String me_phone;
	private String me_authority;
	
	public void setMe_birth(String me_birth)  {		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.me_birth = format.parse(me_birth);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("날짜정보 에러");
			System.out.println("birth 정보 : " +  me_birth);
		}
	}

}
