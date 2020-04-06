package lt.daivospakalikai.academysurvey.admincomment;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminCommentResponseMapper implements RowMapper<AdminCommentResponse> {

    @Override
    public AdminCommentResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AdminCommentResponse(
            rs.getInt("id"),
            rs.getInt("survey_id"),
            rs.getInt("admin_id"),
            rs.getString("comment"),
            rs.getLong("time_stamp"),
            rs.getString("name"),
            rs.getString("surname")
        );
    }
}
