package lt.daivospakalikai.academysurvey.Sumbission;

import io.swagger.annotations.ApiModel;
import java.util.Objects;

@ApiModel("PackageSubmissionAnswer")
class Answer {


  private String answer;

  public Answer() {
  }

  public Answer(String answer) {
    this.answer = answer;
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
    return Objects.equals(answer, answer1.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(answer);
  }

  @Override
  public String toString() {
    return "Answer{" +
        "answer='" + answer + '\'' +
        '}';
  }
}
