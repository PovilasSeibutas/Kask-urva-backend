package lt.daivospakalikai.academysurvey.Submission;

import io.swagger.annotations.ApiModel;
import java.util.List;
import java.util.Objects;

@ApiModel("PackagenSubbmision")
public class Submission {

  private Integer id;
  private List<Answer> answers;

  public Submission() {
  }

  public Submission(Integer id, List<Answer> answers) {
    this.id = id;
    this.answers = answers;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
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
        Objects.equals(answers, that.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, answers);
  }

  @Override
  public String toString() {
    return "Submission{" +
        "id=" + id +
        ", answers=" + answers +
        '}';
  }
}
