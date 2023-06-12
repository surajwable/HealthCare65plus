package com.demo.HealthCare65plus.beans;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.demo.HealthCare65plus.config.UserPrincipal;

@Component
public class UserContext {

    public int getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserPrincipal) {
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            return userPrincipal.getUserId();
        }
        // Return an appropriate value or throw an exception if user ID is not available
        throw new IllegalStateException("User ID not found");
    }
}
