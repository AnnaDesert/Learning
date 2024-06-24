package org.senla.configuration;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.senla.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

import static org.senla.model.PermissionEnum.ADMIN_CREATE;
import static org.senla.model.PermissionEnum.ADMIN_DELETE;
import static org.senla.model.PermissionEnum.ADMIN_READ;
import static org.senla.model.PermissionEnum.ADMIN_UPDATE;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_CREATE;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_DELETE;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_READ;
import static org.senla.model.PermissionEnum.SUPER_ADMIN_UPDATE;
import static org.senla.model.PermissionEnum.USER_READ;
import static org.senla.model.RoleEnum.ADMIN;
import static org.senla.model.RoleEnum.SUPER_ADMIN;
import static org.senla.model.RoleEnum.USER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final UserRepository userRepository;
    private static final String[] WHITE_LIST_URL = {"/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html,",
            "/api/v1/dynamics/**"};
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL).permitAll()
                                .requestMatchers("/api/v1/batch/**").hasAnyRole(SUPER_ADMIN.name())
                                .requestMatchers("/api/v1/batch/**").hasAnyAuthority(SUPER_ADMIN.name())
                                .requestMatchers("/api/v1/catalog/**").hasAnyRole(ADMIN.name(), USER.name(), SUPER_ADMIN.name())
                                .requestMatchers(GET, "/api/v1/catalog/**").hasAnyAuthority(ADMIN_READ.name(), USER_READ.name(), SUPER_ADMIN_READ.name())
                                .requestMatchers(POST, "/api/v1/catalog/**").hasAnyAuthority(ADMIN_CREATE.name())
                                .requestMatchers(PATCH, "/api/v1/catalog/**").hasAnyAuthority(ADMIN_UPDATE.name())
                                .requestMatchers(DELETE, "/api/v1/catalog/**").hasAnyAuthority(ADMIN_DELETE.name())
                                .requestMatchers("/api/v1/category/**").hasAnyRole(ADMIN.name(), USER.name(), SUPER_ADMIN.name())
                                .requestMatchers(GET, "/api/v1/category/**").hasAnyAuthority(ADMIN_READ.name(), USER_READ.name(), SUPER_ADMIN_READ.name())
                                .requestMatchers(POST, "/api/v1/category/**").hasAnyAuthority(SUPER_ADMIN_CREATE.name())
                                .requestMatchers(PATCH, "/api/v1/category/**").hasAnyAuthority(SUPER_ADMIN_UPDATE.name())
                                .requestMatchers(DELETE, "/api/v1/category/**").hasAnyAuthority(SUPER_ADMIN_DELETE.name())
                                .requestMatchers("/api/v1/category/**").hasAnyRole(ADMIN.name(), USER.name(), SUPER_ADMIN.name())
                                .requestMatchers(GET, "/api/v1/dynamics/**").hasAnyAuthority(ADMIN_READ.name(), USER_READ.name(), SUPER_ADMIN_READ.name())
                                .requestMatchers("/api/v1/product/**").hasAnyRole(SUPER_ADMIN.name())
                                .requestMatchers("/api/v1/product/**").hasAnyAuthority(SUPER_ADMIN.name())
                                .requestMatchers("/api/v1/shop/**").hasAnyRole(ADMIN.name(), USER.name(), SUPER_ADMIN.name())
                                .requestMatchers(GET, "/api/v1/shop/**").hasAnyAuthority(ADMIN_READ.name(), USER_READ.name(), SUPER_ADMIN_READ.name())
                                .requestMatchers(POST, "/api/v1/shop/**").hasAnyAuthority(ADMIN_CREATE.name())
                                .requestMatchers(PATCH, "/api/v1/shop/**").hasAnyAuthority(ADMIN_UPDATE.name())
                                .requestMatchers(DELETE, "/api/v1/shop/**").hasAnyAuthority(ADMIN_DELETE.name())
                                .requestMatchers("/api/v1/user/**").hasAnyRole(SUPER_ADMIN.name())
                                .requestMatchers("/api/v1/user/**").hasAnyAuthority(SUPER_ADMIN.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;
        return http.build();
    }
}
