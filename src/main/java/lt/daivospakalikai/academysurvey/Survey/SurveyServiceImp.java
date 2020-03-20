package lt.daivospakalikai.academysurvey.Survey;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImp implements SurveyService {

  @Autowired
  private SurveyRepository surveyRepository;

  @Override
  public void saveSurvey(Survey survey) {
    survey.setTimeStamp(new Date().getTime() / 1000);
    surveyRepository.save(survey);
  }

}
