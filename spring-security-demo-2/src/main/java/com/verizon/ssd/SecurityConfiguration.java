package com.verizon.ssd;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/images/**");
		//these will be actually opened without security pass
	//	** after css means anything after css
	}

	//this time my own login page...page has to be /login
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/cave/**").authenticated();		//.authenticated means any logged in user..
		//going to help us access control, who is allowed, who is not allowed.
		//everybody can visit homepage , only users who are loogeed in can access secretPage
		//anything after cafe available only for authenticated usesr.
		
		
		
		
		
		
		//to enable form based authetication 
		http.formLogin().loginPage("/login")
		.defaultSuccessUrl("/")
		.failureUrl("/login?err=true") //if login suuccessful go to home page else go to login page with param err being true.		
		.usernameParameter("unm")  //giving our own params to match
		.passwordParameter("pwd");
		
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/");
		//informing how to do logout,once he logs out go back to the root
		
	}

	private void usernameParameter(String string) {
		// TODO Auto-generated method stub
		
	}

	private void passwordParameter(String string) {
		// TODO Auto-generated method stub
		
	}

}
