package lt.daivospakalikai.academysurvey.Sub;

import java.util.Objects;

public class Answer {

  private Integer questionId;

  private String question;

  private Integer answerId;

  private String answer;


  public Answer() {
  }

  public Answer(Integer questionId, String question) {
    this.questionId = questionId;
    this.question = question;
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


}
