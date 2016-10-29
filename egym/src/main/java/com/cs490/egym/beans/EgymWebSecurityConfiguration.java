package com.cs490.egym.beans;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class EgymWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	/*
	 * To connect to our h2 database
	@Autowired
	private DataSource dataSource;
	*/
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//			/*
//			.jdbcAuthentication()
//				.withDefaultSchema() --> not needed
//				.dataSource(dataSource)
//				//Sets the query to be used for finding a user by their username.
//				.usersByUsernameQuery(
//					"select username, password, enabled from users where username=?"
//				)
//				//Sets the query to be used for finding a user's authorities by their username.
//				.authoritiesByUsernameQuery(
//					"select username, role from user_roles where username=?"
//				);
//			*/
//					.withUser("user").password("password").roles("USER");
////					.and().withUser("admin").password("password").roles("USER","ADMIN");
//		
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll();
//			.authorizeRequests() <--Can deny access to endpoints (or authenticate)
//				.antMatchers("/info").denyAll().and()
//			.authorizeRequests()
//				.antMatchers("/console/**").permitAll()
//			.authorizeRequests()
//				.anyRequest().authenticated()
//		http
//			.csrf().disable();
//		http
//			.headers().frameOptions().disable();

//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.and()
//				.httpBasic();
//				.permitAll();
	}
}
