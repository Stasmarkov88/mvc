package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.spring.repository")
@ComponentScan(basePackages = "com.spring.services")
@Import({PersistenceConfig.class, SecurityConfig.class})
public class RootConfig {
}
