package com.zard21.jpa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableCaching
public class DatabaseConfig {

    @Value("${bomapp.rdb.service.username:}")
    private String serviceRdbUsername;

    @Value("${bomapp.rdb.service.password:}")
    private String serviceRdbPassword;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/dev_db?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8");
        config.setUsername(serviceRdbUsername);
        config.setPassword(serviceRdbPassword);

        return new HikariDataSource(config);
    }

    @Bean
    JpaTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.zard21.jpa");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put(AvailableSettings.FORMAT_SQL, true);
        jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, "update");
        jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        factoryBean.setJpaProperties(jpaProperties);

        return factoryBean;
    }
}
