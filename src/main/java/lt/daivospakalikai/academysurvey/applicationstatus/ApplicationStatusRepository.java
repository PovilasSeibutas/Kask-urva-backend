package lt.daivospakalikai.academysurvey.applicationstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ApplicationStatusRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ApplicationStatusRepository(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public SubmissionId checkIfApplicationExists(String email) {
        String querySQL = "SELECT survey_id FROM answer WHERE answer = ?";
        return jdbcTemplate.query(querySQL, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, email);
            }
        }, new ApplicationStatusMapper()).get(0);
    }

    public List<String> getEmailFromUser(Integer id) {
        String query = "SELECT answer FROM answer WHERE survey_id = ? ";
        return jdbcTemplate.query(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        }, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
    }

    public List<Integer> getSubmissionIdOfAcceptedUsers() {
        String querySQL = "SELECT id FROM survey WHERE status = 1 AND sent = 0 ";
        return jdbcTemplate.queryForList(querySQL, Integer.class);
    }

    public void saveSentStatus(Integer id) {
        String query = "UPDATE survey SET sent = 1 WHERE id = ? ";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        });
    }

    public void saveApplicationHashcode(Integer id, Long timestamp, String hashcode) {
        String query =
                "INSERT INTO app_status (survey_id, time_stamp, hashcode) VALUES ( ? , ? , ? )";
        jdbcTemplate.update(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
                ps.setLong(2, timestamp);
                ps.setString(3, hashcode);
            }
        });
    }

    public SubmissionId checkIfHashcodeExists(String hashcode) {
        String query = "SELECT survey_id FROM app_status WHERE hashcode = ? ";
       return jdbcTemplate.query(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, hashcode);
            }
        }, new ApplicationStatusMapper()).get(0);
    }
}
