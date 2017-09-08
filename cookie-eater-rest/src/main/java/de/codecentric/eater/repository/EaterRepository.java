package de.codecentric.eater.repository;

import de.codecentric.eater.domain.EaterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EaterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public EaterUser findByUsername(String username) {
        return jdbcTemplate.queryForObject("select firstname, lastname from eater where username = ?", new Object[] {username},  new EaterUserRowMapper());
    }

}
