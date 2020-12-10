package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class MainController{
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("name","鈴木Java五郎");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test")
	public ModelAndView test(ModelAndView mv) {
		mv.addObject("name","伊藤spring");
		mv.setViewName("index");
		return mv;
	}
}