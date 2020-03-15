package lt.daivospakalikai.academysurvey.Answer;

import java.util.List;
import java.util.Set;

public interface AnswerService {

  List<Answer> getAllAnswers();

  void saveAnswer(Answer answer);

  void saveAllAnswers(Set<Answer> answerSet);
}
