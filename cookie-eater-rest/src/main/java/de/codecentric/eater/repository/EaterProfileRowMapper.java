package de.codecentric.eater.repository;

import de.codecentric.eater.domain.EaterProfile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EaterProfileRowMapper implements RowMapper<EaterProfile> {

    @Override
    public EaterProfile mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        EaterProfile eater = new EaterProfile();
        eater.setId(resultSet.getInt("id"));
        eater.setEmail(resultSet.getString("email"));
        eater.setFirstname(resultSet.getString("firstname"));
        eater.setLastname(resultSet.getString("lastname"));
        eater.setStreet(resultSet.getString("street"));
        eater.setCity(resultSet.getString("city"));
        eater.setBirthday(resultSet.getDate("birthday"));
        return eater;
    }
}
