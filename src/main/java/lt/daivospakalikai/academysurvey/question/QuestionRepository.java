package lt.daivospakalikai.academysurvey.question;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

@Service
public class QuestionRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public QuestionRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public List<Question> getAllQuestions() {
    return jdbcTemplate.query("SELECT * FROM `question`", new QuestionRowMapper());
  }

  public void createQuestion(final Question question) {
    String query = "INSERT INTO `question` (`question`, `option`) VALUES ( ? , ? )";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, question.getQuestion());
        ps.setString(2, question.getOption());
      }
    });
  }

  public void updateQuestion(final Question question) {
    String query = "UPDATE `question` SET `question` = ?, `option` = ? WHERE (`id` = ?)";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, question.getQuestion());
        ps.setString(2, question.getOption());
        ps.setInt(3, Integer.valueOf(question.getId()));
      }
    });
  }

  public void deleteQuestion(final Question question) {
    String query = "DELETE FROM `question` WHERE (`id` = ?)";
    jdbcTemplate.update(query, question.getId());
  }


}
