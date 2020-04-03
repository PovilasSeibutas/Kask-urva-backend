package lt.daivospakalikai.academysurvey.message;

public class Message {

  private Integer id;
  private String email;
  private String message;
  private Integer status;

  public Message() {}
  
  public Message(Integer id, String email, String message, Integer status) {
    this.id = id;
    this.email = email;
    this.message = message;
    this.status = status;
  }

  public Message(String email, String message) {
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

  public Integer getStatus() {
    return status;
  }

}
