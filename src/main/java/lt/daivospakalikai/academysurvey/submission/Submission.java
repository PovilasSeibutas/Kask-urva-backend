package lt.daivospakalikai.academysurvey.submission;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.Objects;

@ApiModel("PackagenSubbmision")
public class Submission {

  private Integer id;
  private Integer status;
  private List<Answer> answers;
  private String recaptchaToken;

  public Submission() {
  }

  public Submission(Integer id, Integer status,
      List<Answer> answers, String recaptchaToken) {
    this.id = id;
    this.status = status;
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
        Objects.equals(answers, that.answers) &&
        Objects.equals(recaptchaToken, that.recaptchaToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, answers, recaptchaToken);
  }

  @Override
  public String toString() {
    return "submission{" +
        "id=" + id +
        ", status=" + status +
        ", answers=" + answers +
        ", recaptchaToken=" + recaptchaToken +
        '}';
  }
}
