package lt.daivospakalikai.academysurvey.admincomment;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AdminCommentRowMapper implements RowMapper<AdminComment> {

  @Override
  public AdminComment mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new AdminComment(
        rs.getInt("id"),
        rs.getInt("survey_id"),
        rs.getInt("admin_id"),
        rs.getString("comment"),
        rs.getLong("time_stamp")
    );
  }
}
