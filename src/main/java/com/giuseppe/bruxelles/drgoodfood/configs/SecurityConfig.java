package com.giuseppe.bruxelles.drgoodfood.configs;


import com.giuseppe.bruxelles.drgoodfood.filters.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true, // access à @PreAuthorize(se fait avant la methode) et @PostAuthorize(se fait apres la methode)
        securedEnabled = true, // access à @Secured
        jsr250Enabled = true // access à @RolesAllowed
)public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter authFilter) throws Exception {

        http.csrf().disable(); //Le CSRF il empeche de pouvoir effectuer des requetes dont on en a pas le droit.

//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, /* si on ajoute HttpMethod.POST on ne pourra modifier que les requests en POST relatives au controller ENFANT */ "/enfant/**");  // antMatchers permets de choissir les requests authorizées
//

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //emepche de creer des cookies

        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/consultation").authenticated()
//                .antMatchers("/security/test/all").permitAll()
//                .antMatchers("/security/test/nobody").denyAll()
//                .antMatchers("/security/test/connected").authenticated()
//                .antMatchers("/security/test/not-connected").anonymous()
//                .antMatchers("/security/test/role/user").hasRole("PERSONNEL")
//                .antMatchers("/security/test/role/admin").hasRole("ADMIN")
//                .antMatchers("/security/test/role/any").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/security/test/authority/READ").hasAuthority("ROLE_USER")
//                .antMatchers("/security/test/role/any").hasAnyAuthority("ROLE_USER", "WRITE")
//                .antMatchers("/fake/request/{id::[0-9]+}/**").denyAll()
//                .antMatchers(HttpMethod.DELETE, "/enfant/delete/{id:[0-9]+}").hasRole("ADMIN")
//                .antMatchers("/enfant/**").authenticated()
//                .antMatchers(HttpMethod.DELETE, "/tuteur/delete/{id:[0-9]+}").hasRole("ADMIN")
//                .antMatchers("/tuteur/**").authenticated()
//                .antMatchers("/reservation/child_by_reservation_date").permitAll()
//                .antMatchers("/reservation/**").authenticated()
//                .antMatchers("/user/**").permitAll()
                .anyRequest().permitAll();


        return http.build();

    }

    //CRIPTAGE D4UN MOT DE PASSE
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

        return config.getAuthenticationManager();


    }
}

