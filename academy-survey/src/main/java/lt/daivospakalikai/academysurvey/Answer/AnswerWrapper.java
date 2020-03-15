package lt.daivospakalikai.academysurvey.Answer;

import java.util.Set;

public class AnswerWrapper {

  Set<Answer> answerSet;

  public AnswerWrapper() {
  }

  public AnswerWrapper(Set<Answer> answerSet) {
    this.answerSet = answerSet;
  }

  public Set<Answer> getAnswerSet() {
    return answerSet;
  }

  public void setAnswerSet(Set<Answer> answerSet) {
    this.answerSet = answerSet;
  }
}
