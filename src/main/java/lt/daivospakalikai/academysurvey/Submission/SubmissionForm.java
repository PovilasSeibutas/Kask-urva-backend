package lt.daivospakalikai.academysurvey.Submission;

import java.util.Objects;

public class SubmissionForm {

  private Integer id;
  private Integer questionId;
  private String question;
  private Integer answerId;
  private String answer;

  public SubmissionForm() {
  }

  public SubmissionForm(Integer id, Integer questionId, String question, Integer answerId, String answer) {
    this.id = id;
    this.questionId = questionId;
    this.question = question;
    this.answerId = answerId;
    this.answer = answer;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
    SubmissionForm submissionForm = (SubmissionForm) o;
    return Objects.equals(id, submissionForm.id) &&
        Objects.equals(questionId, submissionForm.questionId) &&
        Objects.equals(question, submissionForm.question) &&
        Objects.equals(answerId, submissionForm.answerId) &&
        Objects.equals(answer, submissionForm.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, questionId, question, answerId, answer);
  }

  @Override
  public String toString() {
    return "SubmissionForm{" +
        "id=" + id +
        ", questionId=" + questionId +
        ", question='" + question + '\'' +
        ", answerId=" + answerId +
        ", answer='" + answer + '\'' +
        '}';
  }
}
