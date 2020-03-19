package lt.daivospakalikai.academysurvey.Sumbission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import java.util.Objects;

@ApiModel("PackageSubmissionAnswer")
class Answer {

  @JsonIgnore
  private Integer id;

  private String answer;

  public Answer() {
  }

  public Answer(Integer id, String answer) {
    this.id = id;
    this.answer = answer;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Answer answer1 = (Answer) o;
    return Objects.equals(id, answer1.id) &&
        Objects.equals(answer, answer1.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, answer);
  }

  @Override
  public String toString() {
    return "Answer{" +
        "id=" + id +
        ", answer='" + answer + '\'' +
        '}';
  }
}
