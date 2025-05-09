package br.com.seuprojeto.dialect;

import org.springframework.data.jdbc.repository.config.DialectResolver;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.dialect.DialectResolver.Rdbms;

import java.util.Optional;

public class SybaseDialectProvider implements DialectResolver.JdbcDialectProvider {
    @Override
    public Optional<Dialect> getDialect(Rdbms rdbms) {
        if ("Sybase".equalsIgnoreCase(rdbms.name())) {
            return Optional.of(SybaseDialect.INSTANCE);
        }
        return Optional.empty();
    }
}