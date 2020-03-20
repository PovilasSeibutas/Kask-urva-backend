package lt.daivospakalikai.academysurvey.Submission;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SubRowMapper implements RowMapper<SubmissionForm> {

  @Override
  public SubmissionForm mapRow(final ResultSet rs, final int number) throws SQLException {

    final SubmissionForm submissionForm = new SubmissionForm();

    submissionForm.setId(rs.getInt("id"));
    submissionForm.setQuestionId(rs.getInt("qid"));
    submissionForm.setQuestion(rs.getString("question"));
    submissionForm.setAnswerId(rs.getInt("aid"));
    submissionForm.setAnswer(rs.getString("answer"));

    return submissionForm;
  }


}
