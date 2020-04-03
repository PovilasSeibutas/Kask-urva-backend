package lt.daivospakalikai.academysurvey.applicationstatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ApplicationStatusMapper implements RowMapper<SubmissionId> {

    @Override
    public SubmissionId mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new SubmissionId(
                rs.getInt("survey_id")
        );
    }
}
