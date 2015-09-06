package com.stockcontrol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("**").permitAll();
//		http
//			.httpBasic()
//			.and()
//			.authorizeRequests()
//				.antMatchers("/resources/**", "/login.html", "/**.js", "/user", "/logout" )
//				.permitAll()
//				.antMatchers("/users/**").hasRole("ADMIN")
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//					.defaultSuccessUrl("/index.html")
//					.loginPage("/login.html")
//					.loginProcessingUrl("/authenticate")
//					.usernameParameter("username")
//					.passwordParameter("password")
//					//.successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
//				.and()
//				.logout()
//					.logoutUrl("/logout")
//					.logoutSuccessUrl("/login.html");
		
		
//		http.authorizeRequests().antMatchers("/admin/**")
//			.access("hasRole('ROLE_ADMIN')").and().formLogin()
//			.loginPage("/login.html").permitAll().failureUrl("/login?error")
//				.usernameParameter("username")
//				.passwordParameter("password")
//				.and().logout().logoutSuccessUrl("/login?logout")
//				.and().csrf();
//				.and().exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}