package kr.green.khl.vo;

import lombok.Data;

@Data
public class TestVO {
	
	int te_num;

	String te_name[] = new String[3];
	
	public void setTe_name1(String name) {		te_name[0] = name;	}
	public void setTe_name2(String name) {		te_name[1] = name;	}
	public void setTe_name3(String name) {		te_name[2] = name;	}

}
