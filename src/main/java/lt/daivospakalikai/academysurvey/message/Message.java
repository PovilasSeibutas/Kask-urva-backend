package lt.daivospakalikai.academysurvey.message;

public class Message {

  private Integer id;
  private String email;
  private String message;

  public Message(Integer id, String email, String message) {
    this.id = id;
    this.email = email;
    this.message = message;
  }

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getMessage() {
    return message;
  }

}
