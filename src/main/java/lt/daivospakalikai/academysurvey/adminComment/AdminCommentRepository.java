package lt.daivospakalikai.academysurvey.adminComment;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

@Service
public class AdminCommentRepository {

  private JdbcTemplate jdbcTemplate;
  private SimpleJdbcInsert simpleJdbcInsert;

  @Autowired
  public AdminCommentRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
    simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
        .withTableName("comment");
  }

  public List<AdminComment> getSumbissionComments(final AdminComment adminComment) {
    String query = "SELECT * FROM academy_survey.comment WHERE survey_id = ? AND admin_id = ?";
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, Integer.valueOf(adminComment.getSubmissionId()));
        ps.setInt(2, Integer.valueOf(adminComment.getAdminId()));
      }
    }, new AdminCommentRowMapper());
  }

  public void createComment(final AdminComment adminComment) {
    final Map<String, Object> parameters = new HashMap<>();
    parameters.put("survey_id", adminComment.getSubmissionId());
    parameters.put("admin_id", adminComment.getAdminId());
    parameters.put("comment", adminComment.getComment());
    parameters.put("time_stamp", new Date().getTime() / 1000);
    simpleJdbcInsert.execute(parameters);
  }


  public void updateComment(final AdminComment adminComment) {
    String query = "UPDATE academy_survey.comment SET comment = ? WHERE id = ?;";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, adminComment.getComment());
        ps.setInt(2, Integer.valueOf(adminComment.getId()));
      }
    });
  }

  public void deleteComment(final AdminComment adminComment) {
    String query = "DELETE FROM academy_survey.comment WHERE (id = ?)";
    jdbcTemplate.update(query, adminComment.getId());
  }

}
