package lt.daivospakalikai.academysurvey.message;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

@Service
public class MessageRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public MessageRepository(final DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public List<Message> getAllMessages() {
    return jdbcTemplate.query("SELECT * FROM message", new MessageRowMapper());
  }

  public void createMessage(final Message message) {
    String query = "INSERT INTO message ( email, message ) VALUES ( ? , ? )";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, message.getEmail());
        ps.setString(2, message.getMessage());
      }
    });
  }

  public List<MessageOutbox> getAllReplays() {
    return jdbcTemplate.query("SELECT * FROM message_outbox", new MessageOutboxRowMapper());
  }

  public void replay(final MessageOutbox messageOutbox) {
    String query =
        "INSERT INTO message_outbox (replay, message_id, admin_id) VALUES ( ? , ? , ? )";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, messageOutbox.getReplay());
        ps.setInt(2, messageOutbox.getMessageId());
        ps.setInt(3, messageOutbox.getAdminId());
      }
    });
  }


  public void deleteMessage(final Message message) {
    String query = "DELETE FROM message WHERE (id = ? )";
    jdbcTemplate.update(query, message.getId());
  }

  public void deleteRelay(final MessageOutbox messageOutbox) {
    String query = "DELETE FROM message_outbox WHERE (id = ? )";
    jdbcTemplate.update(query, messageOutbox.getId());
  }

  public void updateMessageStatus(final Message message) {
    String query = "UPDATE message SET status = ? WHERE (id = ?)";
    jdbcTemplate.update(query, new PreparedStatementSetter() {
      @Override
      public void setValues(PreparedStatement ps) throws SQLException {
        ps.setInt(1, message.getStatus());
        ps.setInt(2, message.getId());
      }
    });
  }

}