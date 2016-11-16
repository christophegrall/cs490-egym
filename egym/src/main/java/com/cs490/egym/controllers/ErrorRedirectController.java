package com.cs490.egym.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * This class handles white label error pages where the user tries to access endpoints that don't exist/aren't created yet.
 */
@Controller
public class ErrorRedirectController implements ErrorController {
	
	private static final String PATH = "/error";
	
	@RequestMapping(value=PATH)
	public String error(){
		return "index.html";
	}

	@Override
	public String getErrorPath(){
		return PATH;
	}
	
}
