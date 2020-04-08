package lt.daivospakalikai.academysurvey.submission;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.Objects;

@ApiModel("PackagenSubbmision")
public class Submission {

  private Integer id;
  private Integer status;
  private Integer gdprId;
  private Long timeStamp;
  private Integer sent;
  private List<Answer> answers;
  private String recaptchaToken;

  public Submission() {
  }

  public Submission(Integer id, Integer status, Integer gdprId, Long timeStamp, Integer sent,
      List<Answer> answers, String recaptchaToken) {
    this.id = id;
    this.status = status;
    this.gdprId = gdprId;
    this.timeStamp = timeStamp;
    this.sent = sent;
    this.answers = answers;
    this.recaptchaToken = recaptchaToken;
  }

  public Integer getId() {
    return id;
  }

  public Integer getStatus() {
    return status;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public String getRecaptchaToken() {
    return recaptchaToken;
  }

  public Integer getGdprId() {
    return gdprId;
  }

  public Long getTimeStamp() {
    return timeStamp;
  }

  public Integer getSent() {
    return sent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Submission that = (Submission) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(status, that.status) &&
        Objects.equals(gdprId, that.gdprId) &&
        Objects.equals(timeStamp, that.timeStamp) &&
        Objects.equals(sent, that.sent) &&
        Objects.equals(answers, that.answers) &&
        Objects.equals(recaptchaToken, that.recaptchaToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, gdprId, timeStamp, sent, answers, recaptchaToken);
  }

  @Override
  public String toString() {
    return "Submission{" +
        "id=" + id +
        ", status=" + status +
        ", gdprId=" + gdprId +
        ", timeStamp=" + timeStamp +
        ", sent=" + sent +
        ", answers=" + answers +
        ", recaptchaToken='" + recaptchaToken + '\'' +
        '}';
  }
}
