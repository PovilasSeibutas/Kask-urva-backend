package lt.daivospakalikai.academysurvey.Submission;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import lt.daivospakalikai.academysurvey.Survey.Survey;
import lt.daivospakalikai.academysurvey.Survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubmissionRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  SurveyService surveyService;

  @Autowired
  public SubmissionRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public List<SubmissionForm> getAll() {
    String query = "SELECT s.id, q.id as qid, q.question, a.id as aid, a.answer\n"
        + "FROM academy_survey.survey s, academy_survey.answer a, academy_survey.question q\n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id";
    return jdbcTemplate.query(query, new SubRowMapper());
  }

  public void saveSubmission(final List<Answer> answerList) {
    String query =
        "INSERT INTO `academy_survey`.`answer` (`answer`, `question_id`, `survey_id`) VALUES (?, ?, ?)";
    Survey survey = new Survey();
    surveyService.saveSurvey(survey);
    jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setString(1, answerList.get(i).getAnswer());
        ps.setInt(2, Integer.valueOf(answerList.get(i).getQuestionId()));
        ps.setInt(3, Integer.valueOf(survey.getId()));
      }

      @Override
      public int getBatchSize() {
        return answerList.size();
      }
    });
  }
}