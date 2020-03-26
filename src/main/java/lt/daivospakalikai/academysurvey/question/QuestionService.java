package lt.daivospakalikai.academysurvey.question;

import java.util.List;

public interface QuestionService {

  List<Question> getAllQuestions();

  void saveQuestion(Question question);

}
