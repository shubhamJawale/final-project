package com.project.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class ConfigurationClass extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/**","/contractor/**").permitAll().anyRequest().authenticated()
	       .and().csrf().disable();
		// super.configure(http);
	}
}
