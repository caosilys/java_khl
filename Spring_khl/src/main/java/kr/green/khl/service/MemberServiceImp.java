package kr.green.khl.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.khl.dao.MemberDAO;
import kr.green.khl.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public MemberVO login(MemberVO member) {
		
		if(member == null || member.getMe_id() == null) return null;
		MemberVO user = memberDao.getMember(member.getMe_id());

		//로그인에 성공하면 회원정보를 실패하면 null을 반환		
	    if(user != null && passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {	       
	    	return user;	        
	    }
		return null;
	}

	public boolean signup(MemberVO member) {
		
		System.out.println(member);
		
		if(member == null) return false;
		if(member.getMe_id() == null) return false;
		if(member.getMe_pw() == null) return false;
		
		// 이미있는 아이디 예외처리
		if(memberDao.getMember(member.getMe_id()) != null) {
			System.out.println("아이디 중복");
			return false;		
		}
		//암호화된 비밀번호
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		memberDao.isertMember(member);	
		return true; 
		
	}
	
	@Override
	public String checkId(String id) {
		MemberVO member = memberDao.getMember(id);
		if(member != null) return "false";
		return "true";
	
	}

	@Override
	public MemberVO updateMember(MemberVO input, MemberVO user) {
		if(input == null || user == null) return null;
		if(input.getMe_name() == null || input.getMe_birth() == null || input.getMe_gender() == null) return null;		
		if(input.getMe_address() == null || input.getMe_address().length() == 0) input.setMe_address(user.getMe_address());
		if(input.getMe_pw() == null || input.getMe_pw().length() == 0) input.setMe_pw(user.getMe_pw());
		else {
			String encPw = passwordEncoder.encode(input.getMe_pw());
			input.setMe_pw(encPw); 
		}
		input.setMe_id(user.getMe_id());
		
		System.out.println(input);
		memberDao.updateMember(input);
		
		return memberDao.getMember(user.getMe_id());
	}

	@Override
	public String findMemberId(MemberVO member) {
		if(member == null) return "err";		
		String userId = memberDao.findMemberId(member);
		if(userId == null ) return "err";
				
		return userId;
	}

	@Override
	public String findMemberPw(MemberVO member) {
		
		MemberVO user = memberDao.getMember(member.getMe_id());
		
		if(user == null || !user.getMe_email().equals(member.getMe_email())) return "false";
		
		// 임시비밀번호 생성
		String newPw = createRandomPw(6);
		
		// 이메일로 새 비밀번호 전송	
		String  reponseMsg = sendNewPw(user , newPw);
		
		//비밀번호 메일전송 실패시 업데이트 하지 않기
		if(reponseMsg.equals("false")) return reponseMsg;
		
		//생성된 비밀번호를 암호화해서 db update
		String encPw = passwordEncoder.encode(newPw);
		user.setMe_pw(encPw);
		memberDao.updateMember(user);
					
		return reponseMsg;
	}
	
	private String sendNewPw(MemberVO user, String newPw) {
		
		String setfrom = "caosilys89@gmail.com";         
	    String tomail  = user.getMe_email();     // 받는 사람 이메일
	    String title   = "비밀번호 변경";      // 제목
	    String content = "새 비밀번호는 " + newPw + "입니다";    // 내용

	    try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	        return "false";
	    }
	    
	    return "true";
	}
	
	private String createRandomPw(int maxsize) {
		
		String newPw ="";
		
		for(int i = 0 ; i < maxsize ; i++) {
			int r = (int)(Math.random() * 62);
			if(0 <= r && r <= 9) {
				newPw += (char)('0' + r);
			}
			else if(r <= 35) {
				newPw += (char)('a' + (r-10));
			}
			else {
				newPw += (char)('A' + (r-36));
			}
		}
		
		return newPw;
	}

	@Override
	public void updateAutologin(MemberVO user) {
		if(user == null) return;
		
		memberDao.updateAutoLogin(user);
		
	}

	@Override
	public MemberVO selectMemberBySessionId(String me_session_id) {
		
		return memberDao.selectMemberBySessionId(me_session_id);
		
	}
}
