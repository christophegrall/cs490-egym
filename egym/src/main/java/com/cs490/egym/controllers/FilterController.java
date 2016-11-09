package com.cs490.egym.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/filter", method = RequestMethod.GET)
public class FilterController {
	@RequestMapping("/filter1")
	public void filter1() {
		
	}
	@RequestMapping("/filter2")
	public void filter2(){
		
	}
}
