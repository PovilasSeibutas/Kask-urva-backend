package lt.daivospakalikai.academysurvey.message;

public class MessageOutbox {

  private Integer id;
  private String replay;
  private Integer messageId;
  private Integer adminId;
  private String name;
  private String surname;


  public MessageOutbox() {
  }

  public MessageOutbox(Integer id, String replay, Integer messageId, Integer adminId, String name,
      String surname) {
    this.id = id;
    this.replay = replay;
    this.messageId = messageId;
    this.adminId = adminId;
    this.name = name;
    this.surname = surname;
  }

  public Integer getId() {
    return id;
  }

  public String getReplay() {
    return replay;
  }

  public Integer getMessageId() {
    return messageId;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }
}
