package lt.daivospakalikai.academysurvey.emailsend;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyIdRowMapper implements RowMapper<SurveyId> {
    @Override
    public SurveyId mapRow(ResultSet rs, int rowNum) throws SQLException {
       return new SurveyId(
        rs.getInt("id"));
    }
}
