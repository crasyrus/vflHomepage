/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewares.springboottest.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 *
 * @author Klaus
 */
@Configuration
 @EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/admin/**").authenticated()
//            .antMatchers("/views/admin/**").authenticated()
            .antMatchers("/admin/a/**").hasRole("A-JUGEND")
            .antMatchers("/addmin/b/**").hasRole("B-JUGEND")
            .antMatchers("/admin/c/**").hasRole("C-JUGEND")
            .antMatchers("/admin/d/**").hasRole("D-JUGEND")
            .antMatchers("/admin/e1/**").hasRole("E1-JUGEND")
            .antMatchers("/admin/e2/**").hasRole("E2-JUGEND")
            .antMatchers("/admin/f1/**").hasRole("F1-JUGEND")
            .antMatchers("/admin/f2/**").hasRole("F2-JUGEND")
            .antMatchers("/admin/g/**").hasRole("G-JUGEND")
            .antMatchers("/admin/u17/**").hasRole("U17")
            //            .antMatchers("/**").permitAll()
                        .antMatchers("/index.html","/", "/login", "/user").permitAll()
            //            .anyRequest().authenticated().and()
                        .and().formLogin()
            .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .inMemoryAuthentication()
            .withUser("a-jugend").password("a-jugend").roles("TRAINER", "A-JUGEND").and()
            .withUser("b-jugend").password("b-jugend").roles("TRAINER", "B-JUGEND").and()
            .withUser("c-jugend").password("c-jugend").roles("TRAINER", "C-JUGEND").and()
            .withUser("d-jugend").password("d-jugend").roles("TRAINER", "D-JUGEND").and()
            .withUser("e1-jugend").password("e1-jugend").roles("TRAINER", "E1-JUGEND").and()
            .withUser("e2-jugend").password("e2-jugend").roles("TRAINER", "E2-JUGEND").and()
            .withUser("f1-jugend").password("f1-jugend").roles("TRAINER", "F1-JUGEND").and()
            .withUser("f2-jugend").password("f2-jugend").roles("TRAINER", "F2-JUGEND").and()
            .withUser("g-jugend").password("g-jugend").roles("TRAINER", "G-JUGEND").and()
            .withUser("u17").password("u17").roles("TRAINER", "U17-JUNIORINNEN");
//    auth.jdbcAuthentication().dataSource(dataSource)
//            .usersByUsernameQuery(
//                    "select username,password from user where username=?")
//            .authoritiesByUsernameQuery(
//                    "Select username, role from (\n"
//                    + "	select username as username, role as role from user_role \n"
//                    + "	union\n"
//                    + "	select u.username as username, 'MANAGEMENT' as role from user u inner join management m on u.username = m.username\n"
//                    + "    union\n"
//                    + "    SELECT u.username as username, 'TRAINER' as role from user u inner join trainer t on u.username = t.username\n"
//                    + "	union\n"
//                    + "    SELECT u.username as username, UPPER(te.name) as role from user u \n"
//                    + "		inner join trainer tr on u.username = tr.username \n"
//                    + "        inner join trainer_team tt on  tr.id = tt.trainer \n"
//                    + "        inner join team te on tt.team = te.id\n"
//                    + "	) as t \n"
//                    + "where username = ?");
  }
}
