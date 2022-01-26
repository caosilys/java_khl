package kr.green.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.*;


@Data
public class CommantVO {
	
	
	private int co_num;
	private int co_bd_num;
	private int co_ori_num;
	
	private String co_me_id;
	private String co_del;
	private String co_content;
	
	private Date co_reg_date;
	
	@Setter(AccessLevel.PROTECTED)
	private String co_date;
		
	public void setDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");		
		co_date = sdf.format(co_reg_date);
	}
	

	
	
}
