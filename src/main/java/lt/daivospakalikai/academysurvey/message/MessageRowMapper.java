package lt.daivospakalikai.academysurvey.message;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MessageRowMapper implements RowMapper<Message> {

  @Override
  public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Message(
        rs.getInt("id"),
        rs.getString("email"),
        rs.getString("message"),
        rs.getInt("status")
    );
  }
}

