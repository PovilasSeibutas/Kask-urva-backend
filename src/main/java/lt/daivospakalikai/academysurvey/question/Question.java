package lt.daivospakalikai.academysurvey.question;

import java.util.Objects;

public class Question {

  private Integer id;
  private String option;
  private String question;

  public Question() {
  }

  public Question(Integer id, String option, String question) {
    this.id = id;
    this.option = option;
    this.question = question;
  }

  public Integer getId() {
    return id;
  }

  public String getOption() {
    return option;
  }

  public String getQuestion() {
    return question;
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
        Objects.equals(option, question1.option) &&
        Objects.equals(question, question1.question);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, option, question);
  }

  @Override
  public String toString() {
    return "Question{" +
        "id=" + id +
        ", option='" + option + '\'' +
        ", question='" + question + '\'' +
        '}';
  }
}
