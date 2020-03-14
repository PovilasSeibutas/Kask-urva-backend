package lt.daivospakalikai.academysurvey.Question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
    private Set<Answer> answerSet;

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

    public Set<Answer> getAnswerSet() {
      return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
      this.answerSet = answerSet;
    }

    @Override
    public int hashCode() {
      int hash = 0;
      hash += (id != null ? id.hashCode() : 0);
      return hash;
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof Question)) {
        return false;
      }
      Question other = (Question) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
        return false;
      }
      return true;
    }

    @Override
    public String toString() {
      return "Question{" +
          "id=" + id +
          ", type='" + type + '\'' +
          ", question='" + question + '\'' +
          ", answerSet=" + answerSet +
          '}';
    }
  }
