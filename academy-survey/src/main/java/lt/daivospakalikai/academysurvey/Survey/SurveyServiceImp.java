package lt.daivospakalikai.academysurvey.Survey;

import java.util.Date;
import java.util.List;
import java.util.Set;
import lt.daivospakalikai.academysurvey.Answer.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImp implements SurveyService {

  private SurveyRepository surveyRepository;

  @Autowired
  private SurveyServiceImp(SurveyRepository surveyRepository) {
    this.surveyRepository = surveyRepository;
  }

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
  public Set<Answer> getAnswersBySurveyId(Integer id) {
    return surveyRepository.findById(id).get().getAnswerSet();
  }

}
