package com.cs490.egym.beans.security.services;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {
	private static final long serialVersionUID = 6720814258927079607L;
	
	private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
