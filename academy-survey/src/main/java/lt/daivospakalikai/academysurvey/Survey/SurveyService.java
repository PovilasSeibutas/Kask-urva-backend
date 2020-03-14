package lt.daivospakalikai.academysurvey.Survey;

import java.util.List;

public interface SurveyService {

  List<Survey> getAllSurveys();

  void saveSurvey(Survey survey);

}
