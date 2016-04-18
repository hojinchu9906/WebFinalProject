package com.sist.movie;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller("mc")
public class MainController {
	@RequestMapping("main.do")
	public String main_page(HttpServletRequest req){
		
		return null;
	}
}
