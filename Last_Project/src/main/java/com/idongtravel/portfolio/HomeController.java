package com.idongtravel.portfolio;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		return "index";
	}
	@RequestMapping("/companyIntro")
	public String companyIntro(HttpServletRequest request) {
		return "companyIntro/companyIntro";
	}

	@RequestMapping("/noticeBoard")
	public String noticeBoard(HttpServletRequest request) {
		return "board/noticeBoard";
	}
	@RequestMapping("/questionBoard")
	public String questionBoard(HttpServletRequest request) {
		return "board/questionBoard";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "login/login";
	}
	
	@RequestMapping("/busancatelog")
	public String busancatelog(HttpServletRequest request) {
		return "travelpackage/Busan/busancatelog";
	}
	@RequestMapping("/gwanganbridge")
	public String gwanganbridge(HttpServletRequest request) {
		return "travelpackage/Busan/busandata/gwanganbridge";
	}
	@RequestMapping("/seoulcatalog")
	public String seoulcatelog(HttpServletRequest request) {
		return "travelpackage/Seoul/seoulcatalog";
	}
	@RequestMapping("/royalpalace")
	public String royalpalace(HttpServletRequest request) {
		return "travelpackage/Seoul/seouldata/royalpalace";
	}
}
