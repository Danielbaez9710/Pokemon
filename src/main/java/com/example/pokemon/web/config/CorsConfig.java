package com.example.pokemon.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Configuración de CORS (Cross-Origin Resource Sharing) para permitir
 * que el frontend, alojado en una ubicación diferente (por ejemplo, http://localhost:4200),
 * se comunique con el backend sin restricciones relacionadas con el mismo origen.
 */
@Configuration
public class CorsConfig {
    /**
     * Configura y proporciona una fuente de configuración de CORS para la aplicación.
     *
     * @return CorsConfigurationSource que contiene las reglas CORS definidas.
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        // Crea una instancia de CorsConfiguration para definir las políticas de CORS
        CorsConfiguration configuration = new CorsConfiguration();

        // Define los orígenes permitidos para realizar solicitudes al backend.
        // En este caso, se permite solo el origen del frontend local (Angular: http://localhost:4200).
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

        // Define los métodos HTTP permitidos para las solicitudes entrantes.
        // Aquí se permite GET, POST, PUT y DELETE.
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));

        // Alternativamente, si deseas permitir todos los métodos HTTP (incluyendo los no especificados),
        // puedes usar "*". Asegúrate de que esto sea seguro para tu caso de uso.
        configuration.setAllowedMethods(Arrays.asList("*"));

        // Crea una fuente de configuración basada en URL y registra las políticas CORS para todas las rutas.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica CORS a todas las rutas del backend.

        return source;
    }
}
