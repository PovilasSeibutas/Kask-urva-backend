package lt.daivospakalikai.academysurvey.gdpr;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GdprRowMapper implements RowMapper<Gdpr> {

  @Override
  public Gdpr mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Gdpr(
        rs.getInt("id"),
        rs.getString("agreement")
    );
  }

}
