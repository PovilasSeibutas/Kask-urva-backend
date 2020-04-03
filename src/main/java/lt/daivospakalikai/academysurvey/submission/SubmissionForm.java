package lt.daivospakalikai.academysurvey.submission;

import java.util.Objects;

public class SubmissionForm {

  private Integer id;
  private Integer status;
  private Integer questionId;
  private String question;
  private Integer answerId;
  private String answer;
  private Integer gdprId;
  private String option;
  private Long timeStamp;

  public SubmissionForm() {
  }

  public SubmissionForm(Integer id, Integer status, Integer questionId, String question, Integer answerId,
      String answer, Integer gdprId, String option, Long timeStamp) {
    this.id = id;
    this.status = status;
    this.questionId = questionId;
    this.question = question;
    this.answerId = answerId;
    this.answer = answer;
    this.gdprId = gdprId;
    this.option = option;
    this.timeStamp = timeStamp;
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

  public Integer getGdprId() {
    return gdprId;
  }

  public String getOption() {
    return option;
  }

  public Long getTimeStamp() {
    return timeStamp;
  }

  public Answer createNewAnswer() {
    return new Answer(getQuestionId(), getQuestion(), getAnswerId(), getAnswer(), getOption());
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
        Objects.equals(answer, that.answer) &&
        Objects.equals(gdprId, that.gdprId) &&
        Objects.equals(option, that.option) &&
        Objects.equals(timeStamp, that.timeStamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, questionId, question, answerId, answer, gdprId, option, timeStamp);
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
        ", gdprId=" + gdprId +
        ", option='" + option + '\'' +
        ", timeStamp=" + timeStamp +
        '}';
  }
}
