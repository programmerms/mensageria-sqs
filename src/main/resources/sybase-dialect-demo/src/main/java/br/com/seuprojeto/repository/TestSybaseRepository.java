package br.com.seuprojeto.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TestSybaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public TestSybaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> fetchTopRows() {
        return jdbcTemplate.queryForList("SELECT TOP 10 * FROM sysobjects");
    }
}
