package lt.daivospakalikai.academysurvey.exception;

import org.springframework.dao.DataAccessException;

public class NotPresentFieldException extends DataAccessException {

  public NotPresentFieldException(String msg) {
    super(msg);
  }
}
