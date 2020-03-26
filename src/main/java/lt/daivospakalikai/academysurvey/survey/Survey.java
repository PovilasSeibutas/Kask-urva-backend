package lt.daivospakalikai.academysurvey.survey;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
import lt.daivospakalikai.academysurvey.answer.Answer;

@Entity
@Table(name = "survey")
public class Survey implements Serializable {

  private static final long serialVersionUID = 1L;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
  private List<Answer> answerList;

  public Survey() {
  }

  public Survey(Integer id) {
    this.id = id;
  }

  public Survey(@NotNull Long timeStamp) {
    this.timeStamp = timeStamp;
  }

  public Survey(Integer id, @NotNull Long timeStamp, @NotNull int status) {
    this.id = id;
    this.timeStamp = timeStamp;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public Long getTimeStamp() {
    return timeStamp;
  }

  public int getStatus() {
    return status;
  }

  public List<Answer> getAnswerList() {
    return answerList;
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
        Objects.equals(answerList, survey.answerList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, timeStamp, status, answerList);
  }

  @Override
  public String toString() {
    return "survey{" +
        "id=" + id +
        ", timeStamp=" + timeStamp +
        ", status=" + status +
        ", answerSet=" + answerList +
        '}';
  }
}
