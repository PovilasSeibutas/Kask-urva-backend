package lt.daivospakalikai.academysurvey.question;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class QuestionRowMapper implements RowMapper<Question> {

  @Override
  public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Question(
        rs.getInt("id"),
        rs.getString("option"),
        rs.getString("question")
    );
  }
}

