package lt.daivospakalikai.academysurvey.Survey;

import java.util.List;
import java.util.Set;
import lt.daivospakalikai.academysurvey.Answer.Answer;

public interface SurveyService {

  List<Survey> getAllSurveys();

  void saveSurvey(Survey survey);

  Set<Answer> getAnswersBySurveyId(Integer id);

}
