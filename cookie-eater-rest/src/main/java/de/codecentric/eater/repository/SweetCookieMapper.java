package de.codecentric.eater.repository;

import de.codecentric.eater.domain.SweetCookie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SweetCookieMapper implements RowMapper<SweetCookie> {

    @Override
    public SweetCookie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        SweetCookie cookie = new SweetCookie();
        cookie.setName(resultSet.getString("name"));
        return cookie;
    }
}
