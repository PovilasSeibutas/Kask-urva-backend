//package lt.daivospakalikai.academysurvey.admin;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//import javax.sql.DataSource;
//
//import lt.daivospakalikai.academysurvey.applicationstatus.ApplicationStatusMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminRepository {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public AdminRepository(final DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    public Admin getAdmin(final String admin) {
//        String querySQL = "SELECT * FROM admin WHERE username = ?";
//        List<Admin> adminList = jdbcTemplate.query(querySQL, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//                ps.setString(1, admin);
//            }
//        }, new AdminRowMapper());
//        if(!adminList.isEmpty()) {
//            return adminList.get(0);
//        } else {
//            return null;
//        }
//    }
//
//
//}
