package com.example.inklow.security;

import com.example.inklow.controller.RoleController;
import com.example.inklow.controller.UserController;
import com.example.inklow.security.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;

@Component
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
//        securedEnabled = true,
//        jsr250Enabled = true,
        prePostEnabled = true
)
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
                .authenticationEntryPoint((request, response, authException) ->
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage()));

        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/user_authentication").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/user_registration").permitAll()
//
//                // User
//                .antMatchers(HttpMethod.GET, UserController.ENDPOINTS.GET_ALL).hasAuthority(UserController.ENDPOINTS.GET_ALL_PERMISSION)
//                .antMatchers(HttpMethod.POST, UserController.ENDPOINTS.GET).hasAuthority(UserController.ENDPOINTS.GET_PERMISSION)
//                .antMatchers(HttpMethod.POST, UserController.ENDPOINTS.UPDATE).hasAuthority(UserController.ENDPOINTS.UPDATE_PERMISSION)
//                .antMatchers(HttpMethod.POST, UserController.ENDPOINTS.DELETE).hasAuthority(UserController.ENDPOINTS.DELETE_PERMISSION)
//
//                // Role
//                .antMatchers(HttpMethod.POST, RoleController.ROLE_ENDPOINTS.ADD).hasAuthority(RoleController.ROLE_ENDPOINTS.ADD_PERMISSION)
//                .antMatchers(HttpMethod.GET, RoleController.ROLE_ENDPOINTS.GET_ALL).hasAuthority(RoleController.ROLE_ENDPOINTS.GET_ALL_PERMISSION)
//                .antMatchers(HttpMethod.POST, RoleController.ROLE_ENDPOINTS.GET).hasAuthority(RoleController.ROLE_ENDPOINTS.GET_PERMISSION)
//                .antMatchers(HttpMethod.POST, RoleController.ROLE_ENDPOINTS.UPDATE).hasAuthority(RoleController.ROLE_ENDPOINTS.UPDATE_PERMISSION)
//                .antMatchers(HttpMethod.POST, RoleController.ROLE_ENDPOINTS.DELETE).hasAuthority(RoleController.ROLE_ENDPOINTS.DELETE_PERMISSION)
//
//                // Permission
//                .antMatchers(HttpMethod.GET, URL.PERMISSION.GET_ALL).hasAuthority(URL.PERMISSION.GET_ALL_PERMISSION)
//                .antMatchers(HttpMethod.POST, URL.PERMISSION.GET).hasAuthority(URL.PERMISSION.GET_PERMISSION)
//
//                // GENERAL
//                .antMatchers(HttpMethod.GET, "/api/home/getAllUsers").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/addUser").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/deleteUser").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/home/deleteAllUser").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/api/home/getAllRoles").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/addRole").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/deleteRole").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/home/deleteAllRole").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/api/home/getAllPermissions").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/addPermission").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/deletePermission").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/home/deleteAllPermission").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/api/home/getAllRolePermissions").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/addRolePermission").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/deleteRolePermission").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/home/deleteAllRolePermission").permitAll()
//
//                .antMatchers(HttpMethod.GET, "/api/home/getAllUserRoles").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/addUserRole").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/home/deleteUserRole").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/home/deleteAllUserRole").permitAll()
//
                .anyRequest().authenticated();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedMethod(HttpMethod.DELETE);
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.POST);
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}