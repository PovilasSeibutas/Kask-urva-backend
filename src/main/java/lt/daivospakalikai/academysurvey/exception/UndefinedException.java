package lt.daivospakalikai.academysurvey.exception;

import org.springframework.dao.DataAccessException;

public class UndefinedException extends DataAccessException {

  public UndefinedException(String message)  {
    super(message);
  }
}
