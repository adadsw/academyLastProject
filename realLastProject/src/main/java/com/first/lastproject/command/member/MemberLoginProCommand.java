package com.first.lastproject.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;
import com.first.lastproject.dto.MemberDto;

public class MemberLoginProCommand implements MemberCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		int memCode = Integer.parseInt(request.getParameter("memCode"));
		InterfaceMemberDao memberDao = MemberDao.getInstance();
		int result = memberDao.checkMember(id, passwd);
		if(result == 1) {
			request.getSession().setAttribute("id", id);
			MemberDto memberDto = memberDao.getMember(id);
			memberDto.getMileage();
			model.addAttribute("result", result);	//정남아 이 부분은 왜 해놓은 거야?
			memCode = 1;
			model.addAttribute("memCode", memCode); //정남아 이 부분 왜 해놓은 거야?
			return "redirect:/seatList";

		} else if(result == -1) {
			model.addAttribute("result", result);
			return "member/memberLoginForm";
		} else {
			model.addAttribute("result", result);
			return "member/memberLoginForm";
		}
		
	}
}
