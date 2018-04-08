//package com.fitness.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    // Authentication : User --> Roles
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication().withUser("user1").password("secret1")
//                .roles("USER").and().withUser("admin1").password("secret1")
//                .roles("USER", "ADMIN");
//    }
//    // Authorization : Role -> Access
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests()
//                .antMatchers("/api/v1/**")
//                .hasRole("USER").
//                antMatchers("/**")
//                .hasRole("ADMIN").
//                and().csrf().disable().headers().frameOptions().disable();
//    }
//}
