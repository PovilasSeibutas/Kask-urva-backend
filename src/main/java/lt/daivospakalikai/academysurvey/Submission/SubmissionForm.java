package lt.daivospakalikai.academysurvey.Submission;

import java.util.Objects;

public class SubmissionForm {

  private Integer id;
  private Integer status;
  private Integer questionId;
  private String question;
  private Integer answerId;
  private String answer;

  public SubmissionForm() {
  }

  public SubmissionForm(Integer id, Integer status, Integer questionId, String question, Integer answerId,
      String answer) {
    this.id = id;
    this.status = status;
    this.questionId = questionId;
    this.question = question;
    this.answerId = answerId;
    this.answer = answer;
  }

  public Integer getId() {
    return id;
  }

  public Integer getQuestionId() {
    return questionId;
  }

  public String getQuestion() {
    return question;
  }

  public Integer getAnswerId() {
    return answerId;
  }

  public String getAnswer() {
    return answer;
  }

  public Integer getStatus() {
    return status;
  }

  public Answer createNewAnswer(){
    return new Answer(getQuestionId(), getQuestion(), getAnswerId(), getAnswer());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubmissionForm that = (SubmissionForm) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(status, that.status) &&
        Objects.equals(questionId, that.questionId) &&
        Objects.equals(question, that.question) &&
        Objects.equals(answerId, that.answerId) &&
        Objects.equals(answer, that.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, questionId, question, answerId, answer);
  }

  @Override
  public String toString() {
    return "SubmissionForm{" +
        "id=" + id +
        ", status=" + status +
        ", questionId=" + questionId +
        ", question='" + question + '\'' +
        ", answerId=" + answerId +
        ", answer='" + answer + '\'' +
        '}';
  }
}
