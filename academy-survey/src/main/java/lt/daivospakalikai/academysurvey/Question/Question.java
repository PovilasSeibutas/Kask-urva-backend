package lt.daivospakalikai.academysurvey.Question;

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
import javax.validation.constraints.Size;
import lt.daivospakalikai.academysurvey.Answer.Answer;

@Entity
@Table(name = "question")
public class Question implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "type")
  private String type;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 45)
  @Column(name = "question")
  private String question;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
  private List<Answer> answerList;

  public Question() {
  }

  public Question(Integer id) {
    this.id = id;
  }

  public Question(Integer id, String type, String question) {
    this.id = id;
    this.type = type;
    this.question = question;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public List<Answer> getAnswerList() {
    return answerList;
  }

  public void setAnswerList(List<Answer> answerList) {
    this.answerList = answerList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question1 = (Question) o;
    return Objects.equals(id, question1.id) &&
        Objects.equals(type, question1.type) &&
        Objects.equals(question, question1.question) &&
        Objects.equals(answerList, question1.answerList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, question, answerList);
  }

  @Override
  public String toString() {
    return "Question{" +
        "id=" + id +
        ", type='" + type + '\'' +
        ", question='" + question + '\'' +
        ", answerSet=" + answerList +
        '}';
  }
}
