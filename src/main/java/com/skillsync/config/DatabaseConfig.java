package com.skillsync.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.skillsync.repository", "com.skillsync.security"})
@EnableTransactionManagement
public class DatabaseConfig {
    // Puedes agregar configuraciones personalizadas aquí si lo requieres
}

