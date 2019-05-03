package com.xaau.bs.busx.manager.configuration;

import com.xaau.bs.busx.manager.service.impl.MyUserDetailsServiceImpl;
import com.xaau.bs.busx.manager.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * description:
 * 
 * @author Mr.Tsang
 * @date 2019/4/4
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationFailureHandler authenticationFailureHandler;

  @Autowired
  private AuthenticationSuccessHandler authenticationSuccessHandler;

  @Bean
  public UserDetailsService detailsService(){
    return new MyUserDetailsServiceImpl();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
    validateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandler);

    http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin()
            .loginPage("/login")
            .successHandler(authenticationSuccessHandler)
            .failureHandler(authenticationFailureHandler)
//            .failureUrl("/login?error")
//            .defaultSuccessUrl("/index")
            .permitAll()
            .and()
            .authorizeRequests()
            .antMatchers("/css/**","/js/**","/image/**").permitAll()
            .antMatchers("/","/welcome","/code/image","/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutSuccessUrl("/login?logout")
            .permitAll()
            .and()
            .csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.
            inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
            .withUser("123")
            .password(new BCryptPasswordEncoder().encode("123"))
            .roles("ADMIN");
    auth.userDetailsService(detailsService()).passwordEncoder(new BCryptPasswordEncoder());
  }
}
