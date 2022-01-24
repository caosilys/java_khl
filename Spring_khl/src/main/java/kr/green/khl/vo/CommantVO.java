package kr.green.khl.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CommantVO {

	private int co_num;
	private int co_bd_num;
	private int co_ori_num;
	
	private String co_me_id;
	private String co_del;
	private String co_content;
	
	private Date co_reg_date;
	
}
