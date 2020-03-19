package lt.daivospakalikai.academysurvey.Sub;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

@Service
public class SubRepository {

  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private SimpleJdbcInsert simpleJdbcInsert;
  private SimpleJdbcCall simpleJdbcCall;

  @Autowired
  public SubRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
    namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("Sub");
  }

  public List<Sub> getAll() {
    return jdbcTemplate.query(
        "SELECT s.id, q.id as qid, q.question, a.id as aid, a.answer\n"
            + "FROM academy_survey.survey s, academy_survey.answer a, academy_survey.question q\n"
            + "WHERE s.id = a.survey_id AND q.id = a.question_id", new SubRowMapper());
  }

}
