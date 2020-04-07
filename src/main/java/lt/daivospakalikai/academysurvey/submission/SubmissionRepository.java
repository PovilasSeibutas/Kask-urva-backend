package lt.daivospakalikai.academysurvey.submission;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import lt.daivospakalikai.academysurvey.filterandsort.AnswerForm;
import lt.daivospakalikai.academysurvey.filterandsort.SubmissionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

@Service
public class SubmissionRepository {

  private JdbcTemplate jdbcTemplate;
  private Map<String, String> sortFilterMap;
  @Autowired
  SubmissionService submissionService;

  @Autowired
  public SubmissionRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
    sortFilterMap = new HashMap<>();
    sortFilterMap.put("answer", "a.answer");
    sortFilterMap.put("question", "q.question");
    sortFilterMap.put("questionId", "q.id");
    sortFilterMap.put("id", "s.id");
    sortFilterMap.put("status", "s.status");
    sortFilterMap.put("gdprId", "s.gdpr_id");
    sortFilterMap.put("option", "q.option");
    sortFilterMap.put("timeStamp", "s.time_stamp");

  }

  public List<SubmissionForm> getAll() {
    String query = "SELECT s.id as sid, s.status, s.time_stamp, q.id as qid, q.question, a.id as aid, a.answer, "
        + "s.gdpr_id as gid, q.option\n"
        + "FROM survey s, answer a, question q\n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id";
    return jdbcTemplate.query(query, new SubmissionFormRowMapper());
  }

  public void saveSubmissions(final List<Answer> answerList, Integer newSurveyId) {
    String query =
        "INSERT INTO answer (answer, question_id, survey_id) VALUES (?, ?, ?)";
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
    String query = "UPDATE survey SET status = ?, admin_id = ? WHERE (id = ?)";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, submissionStatus.getStatus());
        ps.setInt(2, submissionStatus.getAdminId());
        ps.setInt(3, submissionStatus.getSurveyId());
      }
    });
  }

  public List<SubmissionForm> getSubmissionById(Integer id) {
    String query =
        "SELECT s.id as sid, s.status, s.time_stamp, q.id as qid, q.question, a.id as aid, a.answer, s.gdpr_id as gid, q.option\n"
            + "FROM survey s, answer a, question q\n"
            + "WHERE s.id = a.survey_id AND q.id = a.question_id AND s.id = ? ";
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, id);
      }
    }, new SubmissionFormRowMapper());
  }

  public void deleteSubmission(List<Integer> submissionIdList) {
    String query = "DELETE FROM survey WHERE (id = ? )";
    jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setInt(1, submissionIdList.get(i));
      }

      @Override
      public int getBatchSize() {
        return submissionIdList.size();
      }
    });
  }

  public void deleteSubmissionsByDate(List<Long> timeStampList) {
    if (timeStampList.size() == 2) {
      String query = "DELETE FROM survey WHERE (time_stamp >= ? AND time_stamp <= ? AND id<>0)";
      jdbcTemplate.update(query, new PreparedStatementSetter() {
        @Override
        public void setValues(PreparedStatement ps) throws SQLException {
          ps.setLong(1, timeStampList.get(0));
          ps.setLong(2, timeStampList.get(1));
        }
      });
    }
  }

  public List<SubmissionForm> filterAndSortSubmissions(SubmissionFilter submissionFilter) {
    String havingId = "";
    String orderBy = " order by s.id desc ";
    if (!generateOrderByString(submissionFilter.getSortList(), orderBy).equals(" order by ")) {
      orderBy = generateOrderByString(submissionFilter.getSortList(), orderBy);
    }
    if (submissionFilter.getAnswerForm().getFormat().equals("=")) {
      havingId = new StringBuilder().append(havingId).append(
          " AND q.id = ? AND a.answer = ? ").toString();
    } else if (submissionFilter.getAnswerForm().getFormat().equals("?")) {
      havingId = new StringBuilder().append(havingId).append(
          " AND q.id = ? AND a.answer LIKE ?").toString();
    }
    String query =
        "SELECT s.id as sid, s.status, s.time_stamp, q.id as qid, q.question, a.id as aid, a.answer,\n"
            + "s.gdpr_id as gid, q.option\n"
            + "FROM survey s, answer a, question q\n"
            + "WHERE s.id = a.survey_id AND q.id = a.question_id\n"
            + "AND s.id in (SELECT s.id\n"
            + "FROM survey s, answer a, question q\n"
            + "WHERE s.id = a.survey_id AND q.id = a.question_id" + havingId + ")"
            + orderBy;
    System.out.println(query);
    return getFilteredSubmissions(query, submissionFilter.getAnswerForm());
  }

  private List<SubmissionForm> getFilteredSubmissions(String query, AnswerForm answerForm) {
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, answerForm.getQuestionId());
        if (answerForm.getFormat().equals("?")) {
          ps.setString(2, "%" + answerForm.getAnswer() + "%");
        } else {
          ps.setString(2, answerForm.getAnswer());
        }
        System.out.println(ps.toString());
      }
    }, new SubmissionFormRowMapper());
  }

  private String generateOrderByString(List<String> sortList, String query) {
    if (!sortList.isEmpty()) {
      query = " order by ";
    }
    List<String> sortByList = new ArrayList<>();
    for (String s : sortList) {
      String key = Array.get(s.split("="), 0).toString();
      if (sortFilterMap.get(key) != null) {
        sortByList.add(sortFilterMap.get(key) + " " + Array.get(s.split("="), 1).toString());
      }
    }
    for (int i = 0; i < sortByList.size(); i++) {
      if (i == sortByList.size() - 1) {
        query = new StringBuilder().append(query).append(sortByList.get(i)).toString();
      } else {
        query = new StringBuilder().append(query).append(sortByList.get(i) + ", ").toString();
      }
    }
    return query;
  }

}