package lt.daivospakalikai.academysurvey.Submission;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

@Service
public class SubmissionRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  SubmissionService submissionService;

  @Autowired
  public SubmissionRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public List<SubmissionForm> getAll() {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer\n"
        + "FROM academy_survey.survey s, academy_survey.answer a, academy_survey.question q\n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id";
    return jdbcTemplate.query(query, new SubRowMapper());
  }

  public void saveSubmissions(final List<Answer> answerList) {
    String query =
        "INSERT INTO academy_survey.answer (answer, question_id, survey_id) VALUES (?, ?, ?)";
    Integer newSurveyId = submissionService.getNewSubmissionId();
    jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setString(1, answerList.get(i).getAnswer());
        ps.setInt(2, Integer.valueOf(answerList.get(i).getQuestionId()));
        ps.setInt(3, Integer.valueOf(newSurveyId));
      }

      @Override
      public int getBatchSize() {
        return answerList.size();
      }
    });
  }

  public void updateSubmissionStatus(final SubmissionStatus submissionStatus) {
    String query = "UPDATE academy_survey.survey SET status = ?, admin_id = ? WHERE (id = ?)";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, submissionStatus.getStatus());
        ps.setInt(2, submissionStatus.getAdminId());
        ps.setInt(3, submissionStatus.getSurveyId());
      }
    });
  }

  public List<SubmissionForm> sortSubmissionsByNameAZ() {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer\n"
        + "FROM academy_survey.survey s, academy_survey.answer a, academy_survey.question q\n"
        + "JOIN (select concat(a1.answer, a2.answer) as combined, a1.survey_id as sid -- cai galima keisti tvarka\n"
        + "from academy_survey.answer a1\n"
        + "join academy_survey.answer a2\n"
        + "where a1.survey_id = a2.survey_id \n"
        + "\tand a1.question_id = 1\n"
        + "    and a2.question_id = 2  \n"
        + "    and a1.question_id <> a2.question_id) c \n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id AND s.id = sid\n"
        + "order by combined";
    return jdbcTemplate.query(query, new SubRowMapper());
  }

  public List<SubmissionForm> sortSubmissionsByNameZA() {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer\n"
        + "FROM academy_survey.survey s, academy_survey.answer a, academy_survey.question q\n"
        + "JOIN (select concat(a1.answer, a2.answer) as combined, a1.survey_id as sid -- cai galima keisti tvarka\n"
        + "from academy_survey.answer a1\n"
        + "join academy_survey.answer a2\n"
        + "where a1.survey_id = a2.survey_id \n"
        + "\tand a1.question_id = 1\n"
        + "    and a2.question_id = 2  \n"
        + "    and a1.question_id <> a2.question_id) c \n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id AND s.id = sid\n"
        + "order by combined desc";
    return jdbcTemplate.query(query, new SubRowMapper());
  }

  public List<SubmissionForm> getSubmissionById(Integer id) {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer\n"
        + "FROM academy_survey.survey s, academy_survey.answer a, academy_survey.question q\n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id AND s.id = ?";
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, id);
      }
    }, new SubRowMapper());
  }
}