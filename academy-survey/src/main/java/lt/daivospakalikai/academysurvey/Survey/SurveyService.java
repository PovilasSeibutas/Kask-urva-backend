package lt.daivospakalikai.academysurvey.Survey;

import java.util.List;
import lt.daivospakalikai.academysurvey.Answer.Answer;

public interface SurveyService {

  List<Survey> getAllSurveys();

  void saveSurvey(Survey survey);

  List<Answer> getAnswersBySurveyId(Integer id);

}
