package lt.daivospakalikai.academysurvey.Sumbission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import java.util.Objects;

@ApiModel("PackageSubmissionQuestion")
class Question {

  @JsonIgnore //negerai, nes nesimato post metodo body
  private Integer id;

  private String question;

  private Answer answer;

  public Question() {
  }

  public Question(Integer id, String question,
      Answer answer) {
    this.id = id;
    this.question = question;
    this.answer = answer;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public Answer getAnswer() {
    return answer;
  }

  public void setAnswer(Answer answer) {
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
    Question question1 = (Question) o;
    return Objects.equals(id, question1.id) &&
        Objects.equals(question, question1.question) &&
        Objects.equals(answer, question1.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, question, answer);
  }

  @Override
  public String toString() {
    return "Question{" +
        "id=" + id +
        ", question='" + question + '\'' +
        ", answer=" + answer +
        '}';
  }
}
