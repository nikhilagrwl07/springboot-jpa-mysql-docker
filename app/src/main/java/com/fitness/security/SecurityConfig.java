//package fitness.security;
//
//import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private static String REALM = "MY_TEST_REALM";
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/customers").hasRole("ADMIN")
//                .antMatchers("/customers/search/**").hasRole("USER")
//                .and().httpBasic().realmName("REALM").authenticationEntryPoint(getBasicAuthEntryPoint())
//
//    }
//
//    @Bean
//    public HttpBasicConfigurer getBasicAuthEntryPoint() throws Exception {
//        return new HttpBasicConfigurer()
//    }
//}
