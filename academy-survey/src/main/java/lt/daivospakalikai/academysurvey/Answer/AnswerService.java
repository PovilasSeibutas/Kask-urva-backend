package lt.daivospakalikai.academysurvey.Answer;

import java.util.List;

public interface AnswerService {

  List<Answer> getAllAnswers();

  void  saveAnswer(Answer answer);
}
