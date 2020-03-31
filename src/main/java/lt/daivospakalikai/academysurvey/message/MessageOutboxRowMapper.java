package lt.daivospakalikai.academysurvey.message;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MessageOutboxRowMapper implements RowMapper<MessageOutbox> {

  @Override
  public MessageOutbox mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new MessageOutbox(
        rs.getInt("id"),
        rs.getString("replay"),
        rs.getInt("message_id"),
        rs.getInt("admin_id")
    );
  }
}
