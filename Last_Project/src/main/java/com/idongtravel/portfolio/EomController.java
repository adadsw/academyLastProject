package com.idongtravel.portfolio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EomController {
	
	@RequestMapping("/gangwondocatlog")
	public String gangwondocatlog(HttpServletRequest request) {
		return "travelpackage/Gangwondo/gangwondocatlog";
	}
	
	@RequestMapping("/jejucatalog")
	public String jejucatalog(HttpServletRequest request) {
		return "travelpackage/Jeju/jejucatalog";
	}
}