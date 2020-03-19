package lt.daivospakalikai.academysurvey.Sub;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SubRowMapper implements RowMapper<Sub> {

  @Override
  public Sub mapRow(final ResultSet rs, final int number) throws SQLException {

    final Sub sub = new Sub();

    sub.setId(rs.getInt("id"));
    sub.setQuestionId(rs.getInt("qid"));
    sub.setQuestion(rs.getString("question"));
    sub.setAnswerId(rs.getInt("aid"));
    sub.setAnswer(rs.getString("answer"));

    return sub;
  }


}
