package lt.daivospakalikai.academysurvey.Survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lt.daivospakalikai.academysurvey.Answer.Answer;

@Entity
@Table(name = "survey")
public class Survey implements Serializable {

  private static final long serialVersionUID = -2268562508199413550L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "time_stamp")
  private Long timeStamp;
  @Basic(optional = false)
  @NotNull
  @Column(name = "status")
  private int status;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "surveyId")
  private Set<Answer> answerSet;

  public Survey() {
  }

  public Survey(Integer id) {
    this.id = id;
  }

  public Survey(Integer id, @NotNull Long timeStamp, @NotNull int status) {
    this.id = id;
    this.timeStamp = timeStamp;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Long getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Set<Answer> getAnswerSet() {
    return answerSet;
  }

  public void setAnswerSet(Set<Answer> answerSet) {
    this.answerSet = answerSet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Survey survey = (Survey) o;
    return status == survey.status &&
        Objects.equals(id, survey.id) &&
        Objects.equals(timeStamp, survey.timeStamp) &&
        Objects.equals(answerSet, survey.answerSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timeStamp, status, answerSet);
  }

  @Override
  public String toString() {
    return "Survey{" +
        "id=" + id +
        ", timeStamp=" + timeStamp +
        ", status=" + status +
        ", answerSet=" + answerSet +
        '}';
  }
}
