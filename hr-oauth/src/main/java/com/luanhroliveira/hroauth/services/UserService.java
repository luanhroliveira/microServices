package com.luanhroliveira.hroauth.services;

import com.luanhroliveira.hroauth.entities.User;
import com.luanhroliveira.hroauth.faignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    private static String EMAIL_NOT_FOUND = "Email Not Found. ";
    private static String EMAIL_FOUND = "Email Found. ";

    public Optional<User> findByEmail(String email) {
        Optional<User> user = userFeignClient.findByEmail(email).getBody();
        if (!user.isPresent()) {
            logger.error(EMAIL_NOT_FOUND + email);
            throw new IllegalArgumentException(EMAIL_NOT_FOUND);
        }
        logger.error(EMAIL_FOUND + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userFeignClient.findByEmail(username).getBody();
        if (!user.isPresent()) {
            logger.error(EMAIL_NOT_FOUND + username);
            throw new UsernameNotFoundException(EMAIL_NOT_FOUND);
        }
        logger.error(EMAIL_FOUND + username);
        return user.get();
    }
}
