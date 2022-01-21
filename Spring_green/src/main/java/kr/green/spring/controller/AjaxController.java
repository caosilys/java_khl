package kr.green.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Controller
public class AjaxController {
	
	@ResponseBody
	@RequestMapping(value ="/ajax/test1") 
	public Map<String, Object> ajaxTest1 (@RequestBody MemberDTO member) {
				
	    HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("name", "홍길동");
	    map.put("address", "청주시");
	    map.put("data", member);
	    
	    return map;
	}
	

}



@Data
class MemberDTO{
	String id;
	String pw;
}
