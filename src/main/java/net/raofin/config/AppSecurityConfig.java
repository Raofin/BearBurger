package net.raofin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig
{
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests()
                .antMatchers("/api/admin/**", "/dashboard", "/manage-roles", "/manage-user", "/add-user", "/manage-food", "/add-food").hasRole("ADMIN")
                .antMatchers("/profile", "/profile-modify", "/payment", "/comments").hasAnyRole("CUSTOMER", "ADMIN")
                .antMatchers("/").permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/login-success")
                .failureUrl("/login?error")
                .and()
            .rememberMe()
                .rememberMeParameter("remember-me")
                .rememberMeCookieName("BearBurger-LoggedIn-User")
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
            .exceptionHandling()
                .accessDeniedPage("/403");

        return httpSecurity.build();
    }
}
