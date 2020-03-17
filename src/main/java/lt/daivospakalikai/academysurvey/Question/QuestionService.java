package lt.daivospakalikai.academysurvey.Question;

import java.util.List;

public interface QuestionService {

  List<Question> getAllQuestions();

  void saveQuestion(Question question);

}
