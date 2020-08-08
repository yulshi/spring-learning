package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

/**
 * @author yulshi
 * @create 2020/06/14 21:47
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  /**
   * 指定授权的配置
   *
   * @param http
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/", "/home").permitAll()
            .anyRequest().hasAuthority("VIP1")
            .and()
            // 自定义login页面
            .formLogin().loginPage("/login").permitAll()
            .and()
            // 开启注销功能
            .logout().logoutSuccessUrl("/").permitAll();

    // 开启'记住我'功能
    http.rememberMe().rememberMeParameter("remember");

  }

//  @Override
//  @Bean
//  protected UserDetailsService userDetailsService() {
//    UserDetails jimmy = User.withDefaultPasswordEncoder().username("jimmy").password("welcome1").roles("USER").build();
//    UserDetails trudy = User.withDefaultPasswordEncoder().username("trudy").password("welcome1").roles("USER").build();
//    return new InMemoryUserDetailsManager(jimmy, trudy);
//  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // 必须指定一个PasswordEncoder，并用它加密password
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode("welcome1");

    // 向内存中添加用户名和密码
    auth.inMemoryAuthentication().passwordEncoder(encoder)
            .withUser("bailey").password(encodedPassword).authorities("VIP1")
            .and()
            .withUser("millie").password(encodedPassword).authorities("VIP2");

//    // 使用数据库管理用户名/密码
//    auth.jdbcAuthentication()
//            .dataSource(dataSource)
//            .passwordEncoder(NoOpPasswordEncoder.getInstance())
//            .usersByUsernameQuery("select username, password, enabled from users where username = ?")
//            .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
  }

}
