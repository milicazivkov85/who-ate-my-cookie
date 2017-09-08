package de.codecentric.eater.repository;


import de.codecentric.eater.domain.EaterUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EaterUserRowMapper implements RowMapper<EaterUser>{

    @Override
    public EaterUser mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        EaterUser eater = new EaterUser();
        eater.setFirstname(resultSet.getString("firstname"));
        eater.setLastname(resultSet.getString("lastname"));
        return eater;
    }
}
