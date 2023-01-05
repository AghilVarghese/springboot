package com.secokta1;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {

	private final LogoutHandler logoutHandler;

	public SecurityConfig(LogoutHandler logoutHandler) {
		this.logoutHandler = logoutHandler;
	}
	
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // TODO configure authentication manager
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // TODO configure web security
//    	http.oauth2Login().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.addLogoutHandler(logoutHandler).and().build();
//    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.oauth2Login().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.addLogoutHandler(logoutHandler).and().build();
	}

}