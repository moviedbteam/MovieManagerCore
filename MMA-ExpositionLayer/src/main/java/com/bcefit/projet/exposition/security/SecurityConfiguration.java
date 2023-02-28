package com.bcefit.projet.exposition.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/v1/*").hasRole("USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/v1/*").hasRole("USER");
        //http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/v1/produit/**").hasAnyRole("ADMIN","USER");
        //http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/v1/produit").hasRole("ADMIN");
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
        http.formLogin().disable();
        return http.build();
    }

}
