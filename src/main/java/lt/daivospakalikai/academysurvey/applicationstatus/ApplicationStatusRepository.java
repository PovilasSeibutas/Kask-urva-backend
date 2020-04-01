package lt.daivospakalikai.academysurvey.applicationstatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void saveApplicationHashcode(Integer id, Long timestamp, String hashcode) {
        String query =
                "INSERT INTO `academy_survey`.`app_status` (`survey_id`, `time_stamp`, `hashcode`) VALUES ( ? , ? , ? )";
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
        System.out.println(query);
       return jdbcTemplate.query(query, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, hashcode);
            }
        }, new ApplicationStatusMapper()).get(0);
    }
}
