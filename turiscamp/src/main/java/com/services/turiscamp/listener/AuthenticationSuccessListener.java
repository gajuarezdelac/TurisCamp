package com.services.turiscamp.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

import com.services.turiscamp.domain.UserPrincipal;
import com.services.turiscamp.utility.LoginAttemptService;

public class AuthenticationSuccessListener {
	
	 private LoginAttemptService loginAttemptService;

	    @Autowired
	    public AuthenticationSuccessListener(LoginAttemptService loginAttemptService) {
	        this.loginAttemptService = loginAttemptService;
	    }

	    @EventListener
	    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
	        Object principal = event.getAuthentication().getPrincipal();
	        if(principal instanceof UserPrincipal) {
	            UserPrincipal user = (UserPrincipal) event.getAuthentication().getPrincipal();
	            loginAttemptService.evictUserFromLoginAttemptCache(user.getUsername());
	        }
	    }

}
