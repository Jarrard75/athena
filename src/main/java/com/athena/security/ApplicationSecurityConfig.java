package com.athena.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.athena.security.ApplicationUserPermission.*;
import static com.athena.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //TODO: Will enable this later
                .authorizeHttpRequests()
                .antMatchers("index","/css/*","/js/*").permitAll()
                .antMatchers("/api/v1/**").hasRole(USER.name())
                .antMatchers(HttpMethod.GET, "/admin/**").hasAuthority(ADMINISTRATOR_READ.getPermission())
                .antMatchers(HttpMethod.POST, "/admin/**").hasAuthority(ADMINISTRATOR_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/admin/**").hasAuthority(ADMINISTRATOR_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/admin/**").hasAuthority(ADMINISTRATOR_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
//                .roles(USER.name()) //ROLE_USER
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
//                .roles(ADMIN.name()) //ROLE_USER
                .authorities(ADMIN.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(admin, user);
    }
}
