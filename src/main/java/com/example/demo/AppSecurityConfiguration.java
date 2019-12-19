package com.example.demo;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
				.exceptionHandling().authenticationEntryPoint((request, response, e) -> {
					response.setContentType("application/json;charset=UTF-8");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.getWriter().write(new JSONObject().put("status", HttpServletResponse.SC_UNAUTHORIZED)
							.put("timestamp", LocalDateTime.now())
							.put("status", HttpServletResponse.SC_UNAUTHORIZED)
							.put("message", "Bad Credentials. Please check Username/Password").toString());
				});
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("kiran.atmakuri").password("{noop}India@2012").roles("USER");
	}
}
