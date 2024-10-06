package br.edu.fema.tccacademia.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    private AutenticacaoViaTokenFilter autenticacaoViaTokenFilter;

    public SecurityConfigurations (AutenticacaoViaTokenFilter autenticacaoViaTokenFilter) {
        this.autenticacaoViaTokenFilter = autenticacaoViaTokenFilter;
    }

    public static List<String> WHITELIST = Arrays.asList(
            "/configuration/security",
            "/configuration/ui",
            "/v3/api-docs",
            "/webjars",
            "/webjars/swagger-ui",
            "/error",
            "/auth/**"
    );
    public static List<String> AUTHENTICATED = Arrays.asList(
            "/caixa/**",
            "/aluno/**",
            "/funcionario/**",
            "/treino/**",
            "/plano/**",
            "/modalidade/**"
    );

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(conf -> conf.configurationSource(request -> {
                    var cors = new CorsConfiguration();
                    cors.setAllowedOrigins(List.of("http://localhost:5173/"));
                    cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                    cors.setAllowedHeaders(List.of("*"));
                    return cors;
                }))
                .authorizeHttpRequests(req -> req
                        .requestMatchers(WHITELIST.toArray(String[]::new)).permitAll()

                        .requestMatchers(AUTHENTICATED.toArray(String[]::new)).authenticated()

                )
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(autenticacaoViaTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
