package lt.daivospakalikai.academysurvey.Submission;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.Objects;

@ApiModel("PackagenSubbmision")
public class Submission {

  private Integer id;
  private Integer status;
  private List<Answer> answers;

  public Submission() {
  }

  public Submission(Integer id, Integer status,
      List<Answer> answers) {
    this.id = id;
    this.status = status;
    this.answers = answers;
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
        Objects.equals(answers, that.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, answers);
  }

  @Override
  public String toString() {
    return "Submission{" +
        "id=" + id +
        ", status=" + status +
        ", answers=" + answers +
        '}';
  }
}
