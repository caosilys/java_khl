package kr.green.khl.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//테이블을 VO로 만들어야함
@Data
public class MemberVO {
	
	private String me_id;
	private String me_pw;
	private String me_name;
	private String me_gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date me_birth;
	private String me_address;
	private String me_phone;
	private String me_authority;
	private String me_email;
	
	private String me_auto_login;
	private String me_session_id;
	private Date me_session_limit;
	
	
	public String getMe_birth_str(){
		String strDate = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(me_birth);
	}

}
