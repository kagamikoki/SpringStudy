package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class MainController{
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("name","名前がここに入ります");
		mv.addObject("age","年齢がここに入ります");
		mv.addObject("height","身長がここに入ります");
		mv.addObject("from","出身地がここに入ります");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/" , method=RequestMethod.POST)
	public ModelAndView indexPost(ModelAndView mv , @RequestParam("nameVal")String name,
	@RequestParam("ageVal")int age,@RequestParam("heightVal")String height,@RequestParam("fromVal")String from){
	mv.addObject("name", name);
	mv.addObject("age", age + 3);
	mv.addObject("height", height);
	mv.addObject("from", from);
	mv.setViewName("index");
	return mv;
	}
}