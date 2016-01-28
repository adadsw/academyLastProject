package com.first.lastproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.first.lastproject.command.seat.SeatCommand;
import com.first.lastproject.command.seat.SeatListCommand;
import com.first.lastproject.command.seat.SeatSelectConfirmFormCommand;
import com.first.lastproject.command.seat.SeatSelectConfirmProCommand;

@Controller
public class CMController {
	
	@RequestMapping("/seatList")
	public String getSeats(HttpServletRequest request, Model model){
		System.out.println("getSeats()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatListCommand(); 
		String viewName = command.execute(model);
		
		return viewName;
		
	}
	@RequestMapping("/seatConfirm")
	public String seatSelectConfirmForm(HttpServletRequest request, Model model){
		System.out.println("seatConfirm()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatSelectConfirmFormCommand(); 
		String viewName = command.execute(model);
		
		return viewName;
		
	}
	@RequestMapping("/seatSelectConfirmPro")
	public String seatSelectConfirmPro(HttpServletRequest request, Model model){
		System.out.println("selectSeats()");
		model.addAttribute("request", request);
		SeatCommand command = new SeatSelectConfirmProCommand();
		String viewName= command.execute(model);
		
		return viewName;
		
	}
}

