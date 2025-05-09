package br.com.seuprojeto.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.relational.core.dialect.DialectResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableRetry
@EnableTransactionManagement
public class Prod10WorkDatasourceConfiguration extends AbstractJdbcConfiguration {

    @Value("${ir3.datasource.sybase.dbnwrk10.driver-classname}")
    private String driver;

    @Value("${ir3.datasource.sybase.dbnwrk10.url}")
    private String url;

    @Value("${ir3.datasource.sybase.dbnwrk10.username}")
    private String username;

    @Value("${ir3.datasource.sybase.dbnwrk10.password}")
    private String password;

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    @Primary
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}