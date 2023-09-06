package com.bharath.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AssignmentConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/getstudent").hasAnyRole("USER")
                .antMatchers(HttpMethod.PUT, "/updatestudent").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/deletestudent").hasAnyRole("ADMIN")
                .and().csrf().disable().headers()
                .frameOptions().disable();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user123`").password("{noop}password").roles("USER").and()
                .withUser("admin").password("{noop}password").roles("ADMIN");
    }

}
