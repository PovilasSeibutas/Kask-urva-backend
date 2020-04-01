package lt.daivospakalikai.academysurvey.submission;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.Objects;

@ApiModel("PackagenSubbmision")
public class Submission {

  private Integer id;
  private Integer status;
  private Integer gdprId;
  private List<Answer> answers;
  private String recaptchaToken;

  public Submission() {
  }

  public Submission(Integer id, Integer status, Integer gdprId,
      List<Answer> answers, String recaptchaToken) {
    this.id = id;
    this.status = status;
    this.gdprId = gdprId;
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
        Objects.equals(answers, that.answers) &&
        Objects.equals(recaptchaToken, that.recaptchaToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, gdprId, answers, recaptchaToken);
  }

  @Override
  public String toString() {
    return "Submission{" +
        "id=" + id +
        ", status=" + status +
        ", gdprId=" + gdprId +
        ", answers=" + answers +
        ", recaptchaToken='" + recaptchaToken + '\'' +
        '}';
  }
}
