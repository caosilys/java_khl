package kr.green.khl.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.khl.service.MemberService;
import kr.green.khl.vo.*;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberServie;
	
	public void postHandle(
		    HttpServletRequest request, 
		    HttpServletResponse response, 
		    Object handler, 
		    ModelAndView modelAndView)
		    throws Exception {
		
		    ModelMap modelMap = modelAndView.getModelMap();
		    MemberVO user = (MemberVO)modelMap.get("user");
		    
		    System.out.println(user);
		    if(user != null) {
		    	
		        HttpSession session = request.getSession();
		        
		        if(user.getMe_auto_login() !=  null) {
		        	
		        	Cookie cookie = new Cookie("loginCookie",  session.getId());
		        	cookie.setPath("/");
		        	int day =7;
		        	int session_limit_sc = 60 * 60 * 24 *day;
		        	cookie.setMaxAge(session_limit_sc);
		        	response.addCookie(cookie);
		        	
		        	Date session_limit = new Date(System.currentTimeMillis() + 1000 * session_limit_sc);
		        	
		        	user.setMe_session_id(session.getId());
		        	user.setMe_session_limit(session_limit);
		        	memberServie.updateAutologin(user);
		        }
		        session.setAttribute("user", user);
		    }
		}

	private int dateAutologin(MemberVO user) {
		// TODO Auto-generated method stub
		return 0;
	}
	}
