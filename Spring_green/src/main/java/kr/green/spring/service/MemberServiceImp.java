package kr.green.spring.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.*;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public MemberVO getMember(String bd_id) {
		
		return memberDao.getMember(bd_id);
	}

	@Override
	public void signUpMember(MemberVO member) {
		if(member == null) return;
		if(member.getMe_id() == null) return;
		if(member.getMe_pw() == null) return;
		
		String encPw = pwEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);		
		memberDao.sighUpMember(member);		
	}

	@Override
	public MemberVO login(MemberVO member) {

		MemberVO user = memberDao.getMember(member.getMe_id());
		
		if(user == null)	return null;
		if(pwEncoder.matches(member.getMe_pw(), user.getMe_pw())) return user;
		return null;
	}

	@Override
	public boolean idDuplicated(String id) {
		MemberVO user =  memberDao.getMember(id);
		if(user == null) return false; // 중복되는가? false 아니다. 중복되지 않는다
		return true;
	}

	@Override
	public MemberVO modifyMember(MemberVO user, MemberVO member) {

		if(member == null || user == null || !user.getMe_id().equals(member.getMe_id())) return null;

		//비밀번호/주소가 없을경우 그대로
		if(member.getMe_address() == null || member.getMe_address().length() == 0) member.setMe_address(user.getMe_address());
		if(member.getMe_pw() == null || member.getMe_pw().length() == 0) member.setMe_pw(user.getMe_pw());
		else {		//비밀번호가 있을경우 새 비밀번호 암호화하여 저장
			
			String encPW = pwEncoder.encode(member.getMe_pw());
			member.setMe_pw(encPW);		
		}	
		member.setMe_authority(user.getMe_authority());
		
		memberDao.updateMember(member);
		
		return memberDao.getMember(member.getMe_id());
	}
	
	
	
	@Override
	public List<MemberVO> getMemberList(PageMaker pm) {
		if(pm == null || pm.getCriteria() == null) return null;
		return memberDao.getMemberList(pm.getCriteria());
	}
	
	@Override
	public Integer getMemberCount() {
		
		return memberDao.getMemberCount();
	}
	

	@Override
	public String changeAutority(MemberVO member, MemberVO user) {
		MemberVO dbUser = memberDao.getMember(member.getMe_id());
		
		System.out.println("입력값 : "+  member);
		System.out.println("계정 : " + user);
		System.out.println("가져옴 : " + dbUser);
		if(member == null || member.getMe_id() == null || member.getMe_id().length() == 0
							   || member.getMe_authority() == null || member.getMe_authority().length() == 0
           || user == null || !	user.getMe_authority().equals("슈퍼관리자")
           || member.getMe_authority().equals("슈퍼관리자") ||
           dbUser == null | dbUser.getMe_authority().equals("슈퍼관리자")) return "fail" ;
		
		dbUser.setMe_authority(member.getMe_authority());
		memberDao.updateMember(dbUser);	
		return "true";
	}
	
	@Override
	public void updateAutologin(MemberVO user) {

		memberDao.updateAutologin(user);		
	}
	
	
	
	@Override
	public String findId(MemberVO member) {
		
		if(member == null || member.getMe_name() == null ||
		  member.getMe_name().length() == 0 || member.getMe_email() == null ||
		  member.getMe_email().length() == 0) return "fail";
		
		String findId = memberDao.findId(member);
		if(findId == null) findId = "none";
		return findId;
	}
	
	@Override
	public String findPw(MemberVO member) {
		if(member == null || member.getMe_id() == null ||
		  member.getMe_id().length() == 0 || member.getMe_email() == null ||
		  member.getMe_email().length() == 0) return "fail";
		
		MemberVO getMember = memberDao.getMember(member.getMe_id());
		
		if(!member.getMe_email().equals(getMember.getMe_email())) return "fail";
		
		String newPw = createRandomPw(6);
		//암호화, 메일전송, 리턴값설정
		String encPw = pwEncoder.encode(newPw);		
		getMember.setMe_pw(encPw);
		memberDao.updateMember(getMember);
		if(sendNewPwToMail(getMember.getMe_email(), newPw)) 	return "true";
		else return "fail";
	
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

	private boolean sendNewPwToMail(String tomail, String newPw){
		
		String setfrom = "caosilys89@gmail.com";         
	    String title   = "임시 비밀번호 발급"  ;    // 제목
	    String content = "변경된 비밀번호는 [" + newPw +"] 입니다";   // 내용

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        
		try {
			messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(tomail);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content);  // 메일 내용
	        mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public MemberVO selectMemberBySessionId(String cookie_id) {
		// TODO Auto-generated method stub
		return memberDao.getMemberBySessionId(cookie_id);
	}



}
