package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@PropertySource("classpath:application-cloud.properties")
@Profile("cloud")
@Configuration
public class DataBaseConfig extends AbstractCloudConfig {

    @Bean
    public DataSource dataSource(@Value("${hana.url}") final String url,
                                 @Value("${hana.user}") final String user,
                                 @Value("${hana.password}") final String password) {

        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(com.sap.db.jdbc.Driver.class.getName())
                .url(url)
                .username(user)
                .password(password)
                .build();
    }
}
