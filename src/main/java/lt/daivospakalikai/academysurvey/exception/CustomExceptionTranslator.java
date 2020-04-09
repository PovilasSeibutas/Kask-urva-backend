package lt.daivospakalikai.academysurvey.exception;

import lt.daivospakalikai.academysurvey.submission.SubmissionController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;

public class CustomExceptionTranslator extends SQLErrorCodeSQLExceptionTranslator {

  private static Logger log = LoggerFactory.getLogger(SubmissionController.class);

  @Override
  protected DataAccessException customTranslate(String task, String sql, SQLException sqlEx) {
    log.error("SQLException", sqlEx);
    switch (sqlEx.getErrorCode()) {
      case 1452:
        throw new NotPresentFieldException("Field which you are trying to reach is not present");
      case 1048:
        throw new NotNullFieldException("Required field is not provided");
      default:
        throw new UndefinedException("Unknown cause of exception");
    }
  }
}
