package com.cs490.egym.beans.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
	
	private static final long serialVersionUID = -8597558753407703419L;

	@Override
	public void commence(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse, 
			AuthenticationException authenticationException)
			throws IOException, ServletException {
		httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

}
