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
        return jdbcTemplate.query("select name, cookie.id from cookie join eater on cookie.eater_id = eater.id where username = ?", new Object[] {username},  new SweetCookieMapper());
    }

    public void delete(Integer id) {
        jdbcTemplate.execute("delete from cookie where id = " + id);
    }

    public void delete(String username) {
        jdbcTemplate.execute("delete from cookie join eater on cookie.eater_id = eater.id where username = '" + username + "'");
    }
}
