package com.example.progettotest.dao;

import com.example.progettotest.model.TNzDpRe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class TNzDpReDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TNzDpReDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final RowMapper<TNzDpRe> rowMapper = (ResultSet rs, int rowNum) ->
            new TNzDpRe(
                    rs.getString("id"),
                    rs.getDate("reference_date"),
                    rs.getString("description"),
                    rs.getInt("amount"),
                    rs.getString("status")
            );

    private String loadSql(String path) {
        try {
            return Files.readString(new ClassPathResource(path).getFile().toPath());
        } catch (IOException e) {
            throw new RuntimeException("Errore nel caricamento del file SQL: " + path, e);
        }
    }

    public List<String> findAllDescriptions() {
        String sql = loadSql("sql/find_all_descriptions.sql");
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public TNzDpRe findById(String id) {
        String sql = loadSql("sql/getById.sql");
        // Uso la versione moderna con varargs
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void deleteById(String id) {
        String sql = loadSql("sql/deleteById.sql");
        jdbcTemplate.update(sql, id);
    }

    public List<TNzDpRe> findAll(String referenceDate) {
        String sql = loadSql("sql/findAll.sql");
        // Uso la versione moderna con varargs
        return jdbcTemplate.query(sql, rowMapper, referenceDate);
    }

    public void fillTNzDpRe(String referenceDate) {
        String sql = loadSql("sql/fillTNZdpre.sql");
        jdbcTemplate.update(sql, referenceDate);
    }
}
