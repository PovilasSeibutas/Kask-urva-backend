package lt.daivospakalikai.academysurvey.Survey;

import java.util.Date;
import java.util.List;
import lt.daivospakalikai.academysurvey.Answer.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImp implements SurveyService {

  @Autowired
  private SurveyRepository surveyRepository;

  @Override
  public List<Survey> getAllSurveys() {
    return surveyRepository.findAll();
  }

  @Override
  public void saveSurvey(Survey survey) {
    survey.setTimeStamp(new Date().getTime() / 1000);
    surveyRepository.save(survey);
  }

  @Override
  public List<Answer> getAnswersBySurveyId(Integer id) {
    return surveyRepository.findById(id).get().getAnswerList();
  }

}
