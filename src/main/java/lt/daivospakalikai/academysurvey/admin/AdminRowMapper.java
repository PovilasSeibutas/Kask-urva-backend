//package lt.daivospakalikai.academysurvey.admin;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.springframework.jdbc.core.RowMapper;
//
//public class AdminRowMapper implements RowMapper<Admin> {
//
//    @Override
//    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new Admin(
//            rs.getInt("id"),
//            rs.getString("username"),
//            rs.getString("password"),
//            rs.getString("name"),
//            rs.getString("surname")
//        );
//    }
//}
//
