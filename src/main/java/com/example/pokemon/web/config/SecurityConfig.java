package com.example.pokemon.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
/**
 * Clase de configuración de seguridad para Spring Security.
 * Define las reglas de autorización, habilita CORS y desactiva CSRF según las necesidades de la aplicación.
 */
@Configuration
public class SecurityConfig {

    /**
     * Configura la cadena de filtros de seguridad para manejar las solicitudes HTTP.
     *
     * @param http instancia de {@link HttpSecurity} que permite definir reglas de seguridad.
     * @return la configuración de la cadena de filtros de seguridad.
     * @throws Exception en caso de errores de configuración.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Configura las reglas de autorización
                .authorizeHttpRequests(authorize ->
                        // Permite todas las solicitudes GET a la ruta "/api/pokedex/**" sin autenticación
                        authorize.requestMatchers(HttpMethod.GET, "/api/pokedex/**").permitAll()
                )
                // Desactiva la protección contra CSRF (Cross-Site Request Forgery)
                .csrf(AbstractHttpConfigurer::disable)
                // Habilita la configuración predeterminada para CORS
                .cors(Customizer.withDefaults());

        // Devuelve la configuración de la cadena de filtros
        return http.build();
    }
}
