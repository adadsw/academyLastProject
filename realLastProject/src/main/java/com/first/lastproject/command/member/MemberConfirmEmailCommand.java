package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.MemberDao;

@Service("memberConfirmEmailCommand")
public class MemberConfirmEmailCommand implements MemberCommand {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap(); // model을 Map으로 변환
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String email = request.getParameter("email");
		int result = memberDao.checkEmail(email);
		
		//request.setAttribute("key값", value나 변수);
		model.addAttribute("email", email);
		model.addAttribute("result", result);
		return "member/confirmEmail";
	}
}
