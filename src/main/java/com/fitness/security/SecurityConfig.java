//package com.fitness.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private PasswordEncoder passwordEncoder;
//    private DataSource dataSource;
//
//
//    @Autowired
//    public SecurityConfig(PasswordEncoder passwordEncoder,DataSource dataSource) {
//        this.passwordEncoder = passwordEncoder;
//        this.dataSource=dataSource;
//    }
//
//    @Value("${spring.queries.users-query}")
//    private String usersQuery;
//
//    @Value("${spring.queries.roles-query}")
//    private String rolesQuery;
//
//    // Authentication : User --> Roles
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//            auth.
//                jdbcAuthentication()
//                .usersByUsernameQuery(usersQuery)
//                .authoritiesByUsernameQuery(rolesQuery)
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder);
//    }
//
//    // Authorization : Role -> Access
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests()
//                .antMatchers("/api/v1/**")
//                .hasRole("USER")
//                .antMatchers("/**")
//                .hasRole("ADMIN")
//                .and().csrf().disable().headers().frameOptions().disable();
//    }
//}
