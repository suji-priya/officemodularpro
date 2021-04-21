package com.acloudzyn.officemodularpro.config;

import java.security.Principal;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class AuthenticationConfig {

	public static String currentUser()
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		return currentUserName;
	}
	
	//or
	
	/*
	 * public String currentUserName(Principal principal) { return
	 * principal.getName(); }
	 */
}
