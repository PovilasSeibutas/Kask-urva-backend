package lt.daivospakalikai.academysurvey.gdpr;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

@Service
public class GdprRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public GdprRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public List<Gdpr> getAllAgreements() {
    return jdbcTemplate.query("SELECT * FROM gdpr", new GdprRowMapper());
  }

  public Gdpr getGdprById(Gdpr gdpr) {
    String query = "SELECT * FROM gdpr WHERE id = ? ";
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, gdpr.getId());
      }
    }, new GdprRowMapper()).get(0);
  }

  public void createGdpr (Gdpr gdpr){
    String query = "INSERT INTO gdpr (agreement) VALUES ( ? )";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, gdpr.getAgreement());
      }
    });
  }
}
