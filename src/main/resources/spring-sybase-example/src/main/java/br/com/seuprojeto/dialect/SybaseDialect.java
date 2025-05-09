package br.com.seuprojeto.dialect;

import org.springframework.data.relational.core.dialect.AnsiDialect;

public class SybaseDialect extends AnsiDialect {
    public static final SybaseDialect INSTANCE = new SybaseDialect();
}