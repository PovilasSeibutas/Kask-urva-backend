package lt.daivospakalikai.academysurvey.Submission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import java.util.Objects;

@ApiModel("PackageSubAnswer")
class Answer {

  private Integer questionId;
  private String question;
  @JsonIgnore
  private Integer answerId;
  private String answer;

  public Answer() {
  }

  public Answer(Integer questionId, String question, Integer answerId, String answer) {
    this.questionId = questionId;
    this.question = question;
    this.answerId = answerId;
    this.answer = answer;
  }

  public Integer getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public Integer getAnswerId() {
    return answerId;
  }

  public void setAnswerId(Integer answerId) {
    this.answerId = answerId;
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
    return Objects.equals(questionId, answer1.questionId) &&
        Objects.equals(question, answer1.question) &&
        Objects.equals(answerId, answer1.answerId) &&
        Objects.equals(answer, answer1.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionId, question, answerId, answer);
  }

  @Override
  public String toString() {
    return "Answer{" +
        "questionId=" + questionId +
        ", question='" + question + '\'' +
        ", answerId=" + answerId +
        ", answer='" + answer + '\'' +
        '}';
  }
}
