package lt.daivospakalikai.academysurvey.submission;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
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

  }

  public List<SubmissionForm> getAll() {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer, s.gdpr_id as gid, q.option\n"
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

  public List<SubmissionForm> sortSubmissionsByNameAZ() {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer, s.gdpr_id as gid, q.option\n"
        + "FROM survey s, answer a, question q\n"
        + "JOIN (select concat(a1.answer, a2.answer) as combined, a1.survey_id as sid\n"
        + "from answer a1\n"
        + "join answer a2\n"
        + "where a1.survey_id = a2.survey_id \n"
        + "\tand a1.question_id = 1\n"
        + "    and a2.question_id = 2  \n"
        + "    and a1.question_id <> a2.question_id) c \n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id AND s.id = sid\n"
        + "order by combined";
    return jdbcTemplate.query(query, new SubmissionFormRowMapper());
  }

  public List<SubmissionForm> sortSubmissionsByNameZA() {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer, s.gdpr_id as gid, q.option\n"
        + "FROM survey s, answer a, question q\n"
        + "JOIN (select concat(a1.answer, a2.answer) as combined, a1.survey_id as sid\n"
        + "from answer a1\n"
        + "join answer a2\n"
        + "where a1.survey_id = a2.survey_id \n"
        + "\tand a1.question_id = 1\n"
        + "    and a2.question_id = 2  \n"
        + "    and a1.question_id <> a2.question_id) c \n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id AND s.id = sid\n"
        + "order by combined desc";
    return jdbcTemplate.query(query, new SubmissionFormRowMapper());
  }

  public List<SubmissionForm> getSubmissionById(Integer id) {
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer, s.gdpr_id as gid, q.option\n"
        + "FROM survey s, answer a, question q\n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id AND s.id = ? ";
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, id);
      }
    }, new SubmissionFormRowMapper());
  }

  public List<SubmissionForm> filterAndSortSubmissions(SubmissionFilter submissionFilter) {
    Map<String, String> filtersMap = new LinkedHashMap<>();
    Map<String, List<String>> typeMap = new LinkedHashMap<>();
    List<String> typeList = new ArrayList<>();
    String query = "SELECT s.id as sid, s.status, q.id as qid, q.question, a.id as aid, a.answer, s.gdpr_id as gid, q.option\n"
        + "FROM survey s, answer a, question q\n"
        + "WHERE s.id = a.survey_id AND q.id = a.question_id\n"
        + "having 1";
    for (String fs : submissionFilter.getFilterList()) {
      String key = Array.get(fs.split("="), 0).toString();
      String value = Array.get(fs.split("="), 1).toString();
      List<String> newTypeList = new ArrayList(Arrays.asList(value));
      typeList.add(key);
      if (filtersMap.containsKey(key)) {
        filtersMap.replace(key, sortFilterMap.get(key) + " in (" + filtersMap.get(key) + ", ? )");
        newTypeList.addAll(typeMap.get(key));
        typeMap.replace(key, newTypeList);
      } else {
        filtersMap.put(key, sortFilterMap.get(key) + "= ?");
        typeMap.put(key, newTypeList);
      }
    }
    for (Map.Entry<String, String> f : filtersMap.entrySet()) {
      query = new StringBuilder().append(query).append(" AND " + f.getValue()).toString();
    }

    if (!generateOrderByString(submissionFilter.getSortList()).equals(" order by ")) {
      query = new StringBuilder().append(query)
          .append(generateOrderByString(submissionFilter.getSortList())).toString();
    }

    return getFilteredSubmissions(query, typeList, getFilteredValues(typeMap));
  }

  private List<SubmissionForm> getFilteredSubmissions(String query, List<String> typeType, List<String> typeValues) {
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        for (int i = 0; i < typeType.size(); i++) {
          if (typeType.get(i).equals("number")) {
            ps.setInt(i + 1, Integer.valueOf(typeValues.get(i)));
          } else {
            ps.setString(i + 1, typeValues.get(i));
          }
        }
      }
    }, new SubmissionFormRowMapper());
  }

  private List<String> getFilteredValues(Map<String, List<String>> typeMap) {
    List<String> typeValues = new ArrayList<>();
    for (Map.Entry<String, List<String>> tp : typeMap.entrySet()) {
      typeValues.addAll(tp.getValue());
    }
    return typeValues;
  }

  private String generateOrderByString(List<String> sortList) {
    String query = " order by ";
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