package lt.daivospakalikai.academysurvey.filterandsort;

public class AnswerForm {

  private Integer questionId;
  private String answer;
  private String format;

  public AnswerForm(Integer questionId, String answer, String format) {
    this.questionId = questionId;
    this.answer = answer;
    this.format = format;
  }

  public Integer getQuestionId() {
    return questionId;
  }

  public String getAnswer() {
    return answer;
  }

  public String getFormat() {
    return format;
  }
}
