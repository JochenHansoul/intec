package be.jochenhansoul.yummieapp.config;

import be.jochenhansoul.yummieapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
author: Kamer Elciyar
 */

@Configuration
@AllArgsConstructor
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService USER_SERVICE;
    private final BCryptPasswordEncoder BCRYPT_PASSWORD_ENCODER;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http/*.csrf().disable()*/
                .authorizeRequests()
                .antMatchers("/sign-up/**", "/sign-in/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/sign-in")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.USER_SERVICE)
                .passwordEncoder(this.BCRYPT_PASSWORD_ENCODER);
    }
}
