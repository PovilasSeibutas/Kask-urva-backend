package lt.daivospakalikai.academysurvey.submission;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SubmissionFormRowMapper implements RowMapper<SubmissionForm> {

  @Override
  public SubmissionForm mapRow(final ResultSet rs, final int number) throws SQLException {

    return new SubmissionForm(
        rs.getInt("sid"),
        rs.getInt("status"),
        rs.getInt("qid"),
        rs.getString("question"),
        rs.getInt("aid"),
        rs.getString("answer"),
        rs.getInt("gid"),
        rs.getString("option"),
        rs.getLong("time_stamp"),
        rs.getInt("sent")
    );
  }


}
