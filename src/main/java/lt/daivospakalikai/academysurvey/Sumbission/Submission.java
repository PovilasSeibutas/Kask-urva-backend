package lt.daivospakalikai.academysurvey.Sumbission;


import java.util.List;
import java.util.Objects;

public class Submission {

  private Integer id;

  private List<Question> questions;

  public Submission() {
  }

  public Submission(Integer id, List<Question> questions) {
    this.id = id;
    this.questions = questions;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Submission that = (Submission) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(questions, that.questions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, questions);
  }

  @Override
  public String toString() {
    return "Submission{" +
        "id=" + id +
        ", questions=" + questions +
        '}';
  }
}
