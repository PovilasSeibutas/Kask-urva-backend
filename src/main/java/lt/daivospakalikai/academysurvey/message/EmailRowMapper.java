package lt.daivospakalikai.academysurvey.message;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailRowMapper implements RowMapper<Email> {

    @Override
    public Email mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Email(
                rs.getString("email")
        );
    }
}