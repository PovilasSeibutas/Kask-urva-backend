package lt.daivospakalikai.academysurvey.question;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

@Service
public class QuestionRepository {

  private JdbcTemplate jdbcTemplate;
  private SimpleJdbcInsert simpleJdbcInsert;
  private OptionToJsonConverter optionToJsonConverter;

  @Autowired
  public QuestionRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
    simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
        .withTableName("question");
    optionToJsonConverter = new OptionToJsonConverter();
  }

  public List<QuestionFromDB> getAllQuestions() {
    return jdbcTemplate.query("SELECT * FROM academy_survey.question", new QuestionRowMapper());
  }

  public void createQuestion(final Question question) {
    String query = "INSERT INTO `academy_survey`.`question` (`question`, `option`) VALUES ( ? , ? )";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, question.getQuestion());
        OptionToJsonConverter converter = new OptionToJsonConverter();
        ps.setString(2, optionToJsonConverter.convertToDatabaseColumn(question.createOption()));
      }
    });
  }

//  public void updateQuestion(final Question question) {
//    String query = "UPDATE academy_survey.question SET question = ?, option = ? WHERE (id = 106)";
//    jdbcTemplate.update(query, new PreparedStatementSetter() {
//      @Override
//      public void setValues(PreparedStatement ps) throws SQLException {
//        ps.setString(1, adminComment.getComment());
//        ps.setInt(2, Integer.valueOf(adminComment.getId()));
//      }
//    });
//  }


}
