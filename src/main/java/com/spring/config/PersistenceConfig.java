package com.spring.config;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Stanislav Markov mailto: stasmarkov88@gmail.com
 */
@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:db-mysql.properties"})
public class PersistenceConfig {

    @Autowired
    Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IOException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.spring.domain");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(getHibernateProperties());
        return factoryBean;
    }

    protected Properties getHibernateProperties() throws IOException {
        PropertiesFactoryBean pfb = new PropertiesFactoryBean();
        pfb.setLocation(new ClassPathResource("hibernate.properties"));
        pfb.afterPropertiesSet();
        return pfb.getObject();
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Preconditions.checkNotNull(environment.getProperty("jdbc.driverClassName")));
        dataSource.setUrl(Preconditions.checkNotNull(environment.getProperty("jdbc.url")));
        dataSource.setUsername(Preconditions.checkNotNull(environment.getProperty("jdbc.user")));
        dataSource.setPassword(Preconditions.checkNotNull(environment.getProperty("jdbc.pass")));
        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws IOException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
