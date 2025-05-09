package br.com.seuprojeto.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableRetry
@Configuration
@EnableTransactionManagement
public class Prod10WorkDatasourceConfiguration {

    public static final String WORK_PROD10_DATASOURCE_BEAN = "workProd10Datasource";

    @Value("${ir3.datasource.sybase.dbnwrk10.driver-class-name}")
    private String driver;

    @Value("${ir3.datasource.sybase.dbnwrk10.url}")
    private String url;

    @Value("${ir3.datasource.sybase.dbnwrk10.username}")
    private String username;

    @Value("${ir3.datasource.sybase.dbnwrk10.password}")
    private String password;

    @Bean(name = WORK_PROD10_DATASOURCE_BEAN)
    @Primary
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = WORK_PROD10_DATASOURCE_BEAN + "JdbcTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
