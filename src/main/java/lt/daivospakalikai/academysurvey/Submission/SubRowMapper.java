package lt.daivospakalikai.academysurvey.Submission;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SubRowMapper implements RowMapper<SubmissionForm> {

  @Override
  public SubmissionForm mapRow(final ResultSet rs, final int number) throws SQLException {

    final SubmissionForm submissionForm = new SubmissionForm(
        rs.getInt("sid"),
        rs.getInt("status"),
        rs.getInt("qid"),
        rs.getString("question"),
        rs.getInt("aid"),
        rs.getString("answer")
    );

    return submissionForm;
  }


}
