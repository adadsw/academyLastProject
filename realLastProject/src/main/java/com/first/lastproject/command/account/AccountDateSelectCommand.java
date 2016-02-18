package com.first.lastproject.command.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.AccountDao;
import com.first.lastproject.dao.AccountDaoImpl;
import com.first.lastproject.dto.AccountDto;

public class AccountDateSelectCommand implements AccountCommand {

	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		AccountDto selTotal = new AccountDto();
		AccountDao dao = AccountDaoImpl.getInstance();
		List <AccountDto> selList = new ArrayList<AccountDto>();
		List <AccountDto> selPrice = new ArrayList<AccountDto>();
		String startday = request.getParameter("startday");
		String endday = request.getParameter("endday");
		selList = dao.getSelectAccountDays(startday, endday);
		selPrice = dao.getSelectAccountPrice(startday, endday);
		selTotal = dao.getSelectTotalAccount(startday, endday);
		model.addAttribute("selList", selList);
		model.addAttribute("selTotal", selTotal);
		model.addAttribute("selPrice", selPrice);
		model.addAttribute("startday", startday);
		model.addAttribute("endday", endday);
		return "/host/account/accountDateSelect";
	}

}
