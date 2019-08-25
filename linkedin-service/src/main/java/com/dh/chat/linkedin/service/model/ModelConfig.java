package com.dh.chat.linkedin.service.model;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Marvin Tola
 * @email mtolapacheco@gmail.com
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "linkedinEntityManagerFactory",
        transactionManagerRef = "linkedinTransactionManager",
        basePackages = "com.dh.chat.linkedin.service.model.repositories")
public class ModelConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean linkedinEntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(usersDataSource());
        factory.setPackagesToScan("com.dh.chat.linkedin.service.model.domain");
        factory.setPersistenceUnitName("LinkedinPU");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(hibernateProperties());

        return factory;
    }

    @Bean
    public DataSource usersDataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public PlatformTransactionManager linkedinTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(linkedinEntityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa.properties")
    public Properties hibernateProperties() {
        return new Properties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }
}
