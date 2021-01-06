package com.example.inklow.security;

import com.example.inklow.security.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@Component
//@EnableGlobalMethodSecurity(
//        securedEnabled = true,
//        jsr250Enabled = true,
//        prePostEnabled = true
//)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private final MyUserDetailService myUserDetailService;
    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfigurer(final JwtRequestFilter jwtRequestFilter, final MyUserDetailService myUserDetailService) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.myUserDetailService = myUserDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage()))
                .and();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user/getUser").hasAuthority("CAN_VIEW_USER_PROFILE")

                // GENERAL
                .antMatchers(HttpMethod.GET, "/api/getAllUsers").permitAll()
                .antMatchers(HttpMethod.GET, "/api/getAllRoles").permitAll()
                .antMatchers(HttpMethod.GET, "/api/getAllPermissions").permitAll()
                .antMatchers(HttpMethod.GET, "/api/getAllRolePermissions").permitAll()
                .antMatchers(HttpMethod.GET, "/api/getAllUserRoles").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}