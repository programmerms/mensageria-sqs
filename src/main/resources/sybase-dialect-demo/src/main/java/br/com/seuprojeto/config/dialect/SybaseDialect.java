package br.com.seuprojeto.config.dialect;

import org.springframework.data.relational.core.dialect.AbstractDialect;
import org.springframework.data.relational.core.dialect.LockClause;
import org.springframework.data.relational.core.sql.SqlIdentifier;

import java.sql.Types;
import java.util.Set;

public class SybaseDialect extends AbstractDialect {

    @Override
    public String getSimpleTypeName(int sqlType) {
        return switch (sqlType) {
            case Types.BOOLEAN -> "bit";
            case Types.VARCHAR -> "varchar";
            case Types.INTEGER -> "int";
            case Types.BIGINT -> "bigint";
            case Types.TIMESTAMP -> "datetime";
            default -> super.getSimpleTypeName(sqlType);
        };
    }

    @Override
    public boolean supportsArrayColumns() {
        return false;
    }

    @Override
    public LockClause getLockClause() {
        return (from, lockMode) -> "with (updlock)";
    }

    @Override
    public Set<String> getReservedKeywords() {
        return Set.of("key", "user", "value", "index");
    }

    @Override
    public boolean supportsGeneratedValues() {
        return true;
    }

    @Override
    public String getGeneratedValuesSelect(String table, String column) {
        return "select @@identity";
    }

    @Override
    public boolean supportsInsertReturning() {
        return false;
    }

    @Override
    public boolean isQuoted(SqlIdentifier identifier) {
        return true;
    }
}
