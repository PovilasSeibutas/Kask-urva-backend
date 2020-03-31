package lt.daivospakalikai.academysurvey.answer;

import java.io.Serializable;
import java.util.Objects;
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
import lt.daivospakalikai.academysurvey.survey.Survey;

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
  @Column(name = "answer")
  private String answer;
  @JoinColumn(name = "survey_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Survey survey;

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

  public String getAnswer() {
    return answer;
  }

  public Survey getSurvey() {
    return survey;
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
    return Objects.equals(id, answer1.id) &&
        Objects.equals(answer, answer1.answer) &&
        Objects.equals(survey, answer1.survey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, answer, survey);
  }


  @Override
  public String toString() {
    return "answer{" +
        "id=" + id +
        ", answer='" + answer + '\'' +
        ", survey=" + survey +
        '}';
  }
}
