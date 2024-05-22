package com.example.pfaapp.Config;


import com.example.pfaapp.metier.ownerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private ownerUserDetailsService ownerUserDetailsService;


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> requests
                        .requestMatchers("/editRealEstate").authenticated()
                        .requestMatchers("/addRealEstate").permitAll()
                        .requestMatchers("/Dashboard").hasRole("ADMIN")
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/addRealEstate", true)
                        .successHandler((request, response, authentication) -> {
                            String redirectUrl = authentication.getAuthorities().stream()
                                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN")) ? "/addRealEstate" : "/realEstate";
                            response.sendRedirect(redirectUrl);
                        })
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(ownerUserDetailsService);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}