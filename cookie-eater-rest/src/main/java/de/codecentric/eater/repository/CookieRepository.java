package de.codecentric.eater.repository;

import de.codecentric.eater.domain.SweetCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CookieRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SweetCookie> findByUsername(String username) {
        return jdbcTemplate.query("select name from cookie where username = ?", new Object[] {username},  new SweetCookieMapper());
    }
}
