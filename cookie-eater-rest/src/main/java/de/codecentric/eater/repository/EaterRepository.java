package de.codecentric.eater.repository;

import de.codecentric.eater.domain.EaterProfile;
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

    public void update(EaterProfile eater) {
        jdbcTemplate.update("update eater set firstname = ?, lastname = ?, email = ?, city = ?, street = ?, birthday = ? where id = ?",
                eater.getFirstname(), eater.getLastname(), eater.getEmail(), eater.getCity(), eater.getStreet(), eater.getBirthday(), eater.getId());
    }

    public EaterProfile findProfileByUsername(String username) {
        return jdbcTemplate.queryForObject("select id, email, firstname, lastname, street, city, birthday from eater where username = ?", new Object[] {username},  new EaterProfileRowMapper());
    }

    public Integer getProfileIdByUsername(String username) {
        return jdbcTemplate.queryForObject("select id from eater where username = ?", new Object[] {username}, Integer.class);
    }
}
