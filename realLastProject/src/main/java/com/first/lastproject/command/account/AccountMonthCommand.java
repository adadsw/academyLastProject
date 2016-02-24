package com.first.lastproject.command.account;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.first.lastproject.dao.AccountDao;
import com.first.lastproject.dto.AccountDto;

@Service("accountMonthCommand")
public class AccountMonthCommand implements AccountCommand {
	
	@Autowired
	AccountDao dao;
	
	@Override
	public String execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		AccountDto mTotal = new AccountDto();
		AccountDto mPriceDto = new AccountDto();
		Calendar calendar = Calendar.getInstance();
		//Map <String, Object> mList = new HashMap<String, Object>();
		ArrayList<AccountDto> mList = new ArrayList<AccountDto>();
		List <AccountDto> mPrice = new ArrayList<AccountDto>();
		int monlist = Integer.parseInt(request.getParameter("monlist"));
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String mapMonth = year +"-"+monlist+"-01";
		String mapNextMonth = year +"-"+(monlist+1)+"-01";
		//System.out.println("mapMonth : " + mapMonth);
		//System.out.println("mapNextMonth : " + mapNextMonth);
		Map <String, String> mapDate = new HashMap <String, String>();
		mapDate.put("mapMonth", mapMonth);
		mapDate.put("mapNextMonth", mapNextMonth);
		
		
		String time = (calendar.get(Calendar.YEAR) +"년 " + monlist + "월");
		System.out.println("monlist : " + monlist);
		
		mList = dao.getMonthAccountDays(mapDate);  //월간 일자 호출
		Calendar today = Calendar.getInstance();
		today.set(today.get(Calendar.YEAR), monlist-1, 1);
		for(int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
			
			String mapPriceStart = year + "-"+monlist+"-"+i+" 00:00:00"; 
			String mapPriceEnd = year + "-"+monlist+"-"+i+" 23:59:59";
			Map <String, String> monthDate = new HashMap <String, String>();
			monthDate.put("mapPriceStart", mapPriceStart);
			monthDate.put("mapPriceEnd", mapPriceEnd);
			System.out.println(mapPriceStart + "+" + mapPriceEnd);
			mPriceDto = dao.getMonthAccountPrice(monthDate); //월간 일자 총액 호출
			mPrice.add(mPriceDto);
			}
		
		String mapTotalPriceStart = year +"-"+monlist+"-"+"01 00:00:00"; 
		String mapTotalPriceEnd = year +"-"+(monlist+1)+"-"+"01 00:00:00";
		System.out.println( "start : " + mapTotalPriceStart + " end : " + mapTotalPriceEnd);
		Map <String, String> monthTotal = new HashMap <String, String>();
		monthTotal.put("mapTotalPriceStart", mapTotalPriceStart);
		monthTotal.put("mapTotalPriceEnd", mapTotalPriceEnd);
		mTotal = dao.getMonthTotalAccount(monthTotal); //월간 총액 호출
		
		model.addAttribute("time", time);
		model.addAttribute("mList", mList);
		model.addAttribute("mPrice", mPrice);
		model.addAttribute("mTotal", mTotal);
		model.addAttribute("monlist", monlist);
		return "/host/account/accountMonth";
	}

}
