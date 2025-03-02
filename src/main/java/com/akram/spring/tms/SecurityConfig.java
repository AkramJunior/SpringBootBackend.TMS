package com.akram.spring.tms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

 @Bean
 public CorsFilter corsFilter() {
     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
     CorsConfiguration config = new CorsConfiguration();
     
     // Autoriser React Native (adresses locales et émulateurs)
     config.addAllowedOrigin("http://localhost:19006");
     config.addAllowedOrigin("http://10.0.2.2:8081"); // Émulateur Android
     
     // Méthodes autorisées
     config.addAllowedMethod("GET");
     config.addAllowedMethod("POST");
     config.addAllowedMethod("PUT");
     config.addAllowedMethod("DELETE");
     
  // Autoriser toutes les origines de développement
     config.addAllowedOriginPattern("*"); // En développement seulement
     config.addAllowedMethod("*");
     // Headers autorisés
     config.addAllowedHeader("*");
     config.setAllowCredentials(true);
     
     source.registerCorsConfiguration("/**", config);
     return new CorsFilter(source);
 }
}