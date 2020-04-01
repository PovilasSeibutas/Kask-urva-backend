package lt.daivospakalikai.academysurvey.submission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel("PackageSubAnswer")
class Answer {

  private Integer questionId;
  @ApiModelProperty(readOnly = true)
  @JsonProperty(access = Access.READ_ONLY)
  private String question;
  @JsonIgnore
  private Integer answerId;
  private String answer;
  private String option;

  public Answer() {
  }

  public Answer(Integer questionId, String question, Integer answerId, String answer, String option) {
    this.questionId = questionId;
    this.question = question;
    this.answerId = answerId;
    this.answer = answer;
    this.option = option;
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

  public String getOption() {
    return option;
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
        Objects.equals(answer, answer1.answer) &&
        Objects.equals(option, answer1.option);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionId, question, answerId, answer, option);
  }

  @Override
  public String toString() {
    return "Answer{" +
        "questionId=" + questionId +
        ", question='" + question + '\'' +
        ", answerId=" + answerId +
        ", answer='" + answer + '\'' +
        ", option='" + option + '\'' +
        '}';
  }
}
