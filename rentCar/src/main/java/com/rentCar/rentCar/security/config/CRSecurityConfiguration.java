package com.rentCar.rentCar.security.config;

import com.rentCar.rentCar.security.CRUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class CRSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private CRUserDetailsService crUserDetailsService;

    public CRSecurityConfiguration(CRUserDetailsService crUserDetailsService){
        this.crUserDetailsService = crUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/users").authenticated()
                .antMatchers("/api/v1/car").authenticated()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().httpBasic();


    }


//cine va face autentificarea
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(crUserDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
