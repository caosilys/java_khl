package kr.green.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	Integer bd_num;
	Integer bd_ori_num;
	Integer bd_views;
	
	String bd_title;
	String bd_content;
	String bd_type;
	String bd_me_id;
	String bd_del;
	
	Date bd_reg_date;
	Date bd_up_date;
	Date bd_del_date;
	
	int bd_up;
	int bd_down;
	
	//화면에 출력할 때 사용됨
	public String getBd_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String strdate = sdf.format(bd_reg_date);
		return strdate;
	}
	
	public String getBd_upd() {
		if(bd_up_date == null) return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String strdate = sdf.format(bd_up_date);
		return strdate;
	}
	
	
	
}
