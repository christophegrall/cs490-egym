package com.cs490.egym.beans.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.cs490.egym.models.Authority;
import com.cs490.egym.models.User;

public class JwtUserFactory {
	private JwtUserFactory() {}

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.isEnabled(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
