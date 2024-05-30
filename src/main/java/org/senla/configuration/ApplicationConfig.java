package org.senla.configuration;


import lombok.RequiredArgsConstructor;
import org.senla.exception.NotFoundResourceException;
import org.senla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.senla.auditing.ApplicationAuditAware;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository userRepository;

    @Bean(name = "org.senla.configuration.SpringDocConfiguration.userDetailsService")
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundResourceException("Not found user on email="+username));
    }

    @Bean(name = "org.senla.configuration.SpringDocConfiguration.authenticationProvider")
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean(name = "org.senla.configuration.SpringDocConfiguration.auditorAware")
    public ApplicationAuditAware auditorAware() {
        return new ApplicationAuditAware();
    }

    @Bean(name = "org.senla.configuration.SpringDocConfiguration.authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean(name = "org.senla.configuration.SpringDocConfiguration.passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
