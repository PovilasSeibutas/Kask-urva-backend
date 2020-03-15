package lt.daivospakalikai.academysurvey.Answer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lt.daivospakalikai.academysurvey.Question.Question;
import lt.daivospakalikai.academysurvey.Survey.Survey;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "answer")
  private String answer;
  @JoinColumn(name = "question_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Question questionId;
  @JoinColumn(name = "survey_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Survey surveyId;

  public Answer() {
  }

  public Answer(Integer id) {
    this.id = id;
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

  public Question getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Question questionId) {
    this.questionId = questionId;
  }

  public Survey getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(Survey surveyId) {
    this.surveyId = surveyId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Answer)) {
      return false;
    }
    Answer other = (Answer) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Answer{" +
        "id=" + id +
        ", answer='" + answer + '\'' +
        ", questionId=" + questionId +
        ", surveyId=" + surveyId +
        '}';
  }
}
