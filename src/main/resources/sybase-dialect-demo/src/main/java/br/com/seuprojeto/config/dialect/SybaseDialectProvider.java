package br.com.seuprojeto.config.dialect;

import org.springframework.data.jdbc.repository.config.DialectResolver;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.jdbc.core.JdbcOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class SybaseDialectProvider implements DialectResolver.JdbcDialectProvider {

    @Override
    public Optional<Dialect> getDialect(JdbcOperations operations) {
        try (Connection connection = operations.getDataSource().getConnection()) {
            String dbProductName = connection.getMetaData().getDatabaseProductName();
            if (dbProductName != null && dbProductName.toLowerCase().contains("sybase")) {
                return Optional.of(new SybaseDialect());
            }
        } catch (SQLException e) {
            // Log or handle as needed
        }
        return Optional.empty();
    }
}
