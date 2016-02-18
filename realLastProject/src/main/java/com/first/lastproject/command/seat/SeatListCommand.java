package com.first.lastproject.command.seat;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.first.lastproject.dao.SeatDao;
import com.first.lastproject.dao.SeatDaoImpl;
import com.first.lastproject.dto.SeatDto;

public class SeatListCommand implements SeatCommand {

	@Override
	public String execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		SeatDao seatDao = SeatDaoImpl.getInstance();

		ArrayList<SeatDto> seats = seatDao.getSeats();
		model.addAttribute("seats", seats);

		String id = (String) request.getSession().getAttribute("id");
		if (id.equals("host")) {
			return "host/seat/seatList";
		} else {
			return "guest/seat/seatList";
		}
	}
}
