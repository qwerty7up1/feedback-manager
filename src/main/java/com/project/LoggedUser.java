package com.project;

import com.project.entity.User;
import com.project.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUser {

    @Autowired
    private AccountRepository accountRepository;

    public User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return accountRepository.findUserByEmail(auth.getName());
    }

}
