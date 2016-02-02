package com.first.lastproject.command.board;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.board.BoardDao;
import com.first.lastproject.dao.board.InterfaceBoardDao;
import com.first.lastproject.dao.member.InterfaceMemberDao;
import com.first.lastproject.dao.member.MemberDao;
import com.first.lastproject.dto.BoardDto;
import com.first.lastproject.dto.MemberDto;

public class BoardWriteProCommand implements BoardCommand {

	@Override
	public String execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		BoardDto dto = new BoardDto();
		dto.setWriter(request.getParameter("writer"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		dto.setIp(request.getRemoteAddr());
		
		InterfaceBoardDao dao = BoardDao.getInstance();
		InterfaceMemberDao memberDao = MemberDao.getInstance();
		int writeResult = dao.writeArticle(dto);
		
		String id = (String) request.getSession().getAttribute("id");
		MemberDto memberDto = memberDao.getMember(id);
		
		if(memberDto.getGet_coupon()==0){
			int makeCouponResult = memberDao.makeCoupon(id);
			model.addAttribute("makeCouponResult", makeCouponResult);
		}
		model.addAttribute("writeResult", writeResult);
		
		return "board/writePro";
	}

}
