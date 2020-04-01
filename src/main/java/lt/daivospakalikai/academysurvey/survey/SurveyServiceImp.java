package lt.daivospakalikai.academysurvey.survey;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyServiceImp implements SurveyService {

  @Autowired
  private SurveyRepository surveyRepository;

  @Override
  public Integer createSurvey(Integer gdprId) {
    return surveyRepository.save(new Survey(new Date().getTime() / 1000, gdprId)).getId();
  }

}
