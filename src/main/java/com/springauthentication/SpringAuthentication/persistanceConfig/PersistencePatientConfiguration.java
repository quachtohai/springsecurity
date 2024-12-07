package com.springauthentication.SpringAuthentication.persistanceConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@PropertySource({ "classpath:persistence-multiple-db-boot.properties" })
@EnableJpaRepositories(
        basePackages = "com.springauthentication.SpringAuthentication.repository",
        entityManagerFactoryRef = "patientEntityManager",
        transactionManagerRef = "patientTransactionManager")
public class PersistencePatientConfiguration {
    @Autowired
    private Environment env;


    @Bean(name = "patientEntityManager")
    public  LocalContainerEntityManagerFactoryBean patientEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(patientDataSource());
        em.setPackagesToScan(
                new String[] { "com.springauthentication.SpringAuthentication.model" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "primaryDB")
    @ConfigurationProperties(prefix = "spring.primary")
    public  DataSource patientDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasourcepatient.url"));
        dataSource.setUsername(env.getProperty("spring.datasourcepatient.username"));
        dataSource.setPassword(env.getProperty("spring.datasourcepatient.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager patientTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                patientEntityManager().getObject());
        return transactionManager;
    }
}

