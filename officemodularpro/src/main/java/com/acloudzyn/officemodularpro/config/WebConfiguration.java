package com.acloudzyn.officemodularpro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.acloudzyn.officemodularpro.repository.AdminRepository;
import com.acloudzyn.officemodularpro.serviceimpl.AdminServiceimpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(basePackageClasses = AdminRepository.class)
@EnableWebSecurity
@Configuration
public class WebConfiguration extends WebSecurityConfigurerAdapter{
	
		
	@Autowired
	private AdminServiceimpl userDetailsService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {    
		
		  http.httpBasic().and() .csrf().disable().authorizeRequests().antMatchers("/**")
		 .authenticated().anyRequest().permitAll().and()
		 .formLogin().permitAll();
		 
        }

		
		  @Override protected void configure(AuthenticationManagerBuilder auth) throws
		  Exception {
		  
		      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		  }


		@Bean
		  public PasswordEncoder passwordEncoder() {
			
			return new PasswordEncoder() {
	            @Override
	            public String encode(CharSequence charSequence) {
	                return charSequence.toString();
	            }

	            @Override
	            public boolean matches(CharSequence charSequence, String s) {
	                return charSequence.toString().equals(s);
	            }
	        };
		}
		 
	
}
