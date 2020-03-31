package lt.daivospakalikai.academysurvey.admincomment;

public class AdminComment {

  private Integer id;
  private Integer submissionId;
  private Integer adminId;
  private String comment;
  private Long timeStamp;

  public AdminComment() {
  }

  public AdminComment(Integer id, Integer submissionId, Integer adminId, String comment, Long timeStamp) {
    this.id = id;
    this.submissionId = submissionId;
    this.adminId = adminId;
    this.comment = comment;
    this.timeStamp = timeStamp;
  }

  public Integer getId() {
    return id;
  }

  public Integer getSubmissionId() {
    return submissionId;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public String getComment() {
    return comment;
  }

  public Long getTimeStamp() {
    return timeStamp;
  }

}


