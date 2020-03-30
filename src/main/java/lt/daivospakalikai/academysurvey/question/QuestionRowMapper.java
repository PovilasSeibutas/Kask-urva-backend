package lt.daivospakalikai.academysurvey.question;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class QuestionRowMapper implements RowMapper<QuestionFromDB> {

  @Override
  public QuestionFromDB mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new QuestionFromDB(
        rs.getInt("id"),
        rs.getString("option"),
        rs.getString("question")
    );
  }
}

