package lt.daivospakalikai.academysurvey.Answer;

import java.util.List;
import lt.daivospakalikai.academysurvey.Survey.Survey;
import lt.daivospakalikai.academysurvey.Survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImp implements AnswerService {

  @Autowired
  private AnswerRepository answerRepository;

  @Autowired
  private SurveyService surveyService;

  @Override
  public List<Answer> getAllAnswers() {
    return answerRepository.findAll();
  }

  @Override
  public void saveAnswer(Answer answer) {
    surveyService.saveSurvey(answer.getSurvey());
    answerRepository.save(answer);
  }

  @Override
  public void saveAllAnswers(List<Answer> answerList) {
    Survey survey = answerList.get(0).getSurvey();
    surveyService.saveSurvey(survey);
    for (Answer a : answerList) {
      a.setSurvey(survey);
    }
    answerRepository.saveAll(answerList);
  }


}
