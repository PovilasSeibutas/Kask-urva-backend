package lt.daivospakalikai.academysurvey.message;

public class MessageOutbox {

  private Integer id;
  private String replay;
  private Integer messageId;
  private Integer adminId;


  public MessageOutbox(Integer id, String replay, Integer messageId, Integer adminId) {
    this.id = id;
    this.replay = replay;
    this.messageId = messageId;
    this.adminId = adminId;
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
}
