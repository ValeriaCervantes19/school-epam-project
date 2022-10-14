package com.epam.school.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig { //extends WebSecurityConfigurerAdapter{
	
//	@Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	
//	 @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests()
//	                .antMatchers("/css/**", "/js/**").permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	                .formLogin()
//	                .loginPage("/login.html")
//	                .permitAll()
//	                .successForwardUrl("/index.html")
//	                .and()
//	                .logout()
//	                .permitAll()
//	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	                .logoutSuccessUrl("/login.html");
//	    }
//	 
//	 @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
//	        auth.inMemoryAuthentication()
//	                .withUser("user")
//	                .password(passwordEncoder.encode("user"))
//	                .roles("OPERATOR")
//	                .and()
//	                .withUser("admin")
//	                .password(passwordEncoder.encode("admin"))
//	                .roles("ADMIN");
//	    }
	 
}
