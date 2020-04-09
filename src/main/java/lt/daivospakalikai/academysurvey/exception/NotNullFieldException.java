package lt.daivospakalikai.academysurvey.exception;

import org.springframework.dao.DataAccessException;

public class NotNullFieldException extends DataAccessException {

  public NotNullFieldException(String message) {
    super(message);
  }
}
