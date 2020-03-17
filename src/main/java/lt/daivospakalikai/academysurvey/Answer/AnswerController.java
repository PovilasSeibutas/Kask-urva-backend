package lt.daivospakalikai.academysurvey.Answer;

import java.util.List;
import lt.daivospakalikai.academysurvey.Survey.Survey;
import lt.daivospakalikai.academysurvey.Survey.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/answers")
public class AnswerController {

  private static Logger log = LoggerFactory.getLogger(AnswerController.class);

  @Autowired
  private AnswerService answerService;

  @Autowired
  private SurveyService surveyService;

  @GetMapping
  public ResponseEntity<List<Answer>> getAnswers() {
    List<Answer> list = answerService.getAllAnswers();
    return new ResponseEntity<List<Answer>>(list, HttpStatus.OK);
  }

  @Transactional
  @PostMapping(consumes = "application/json")
  public void saveAnswer(@RequestBody Answer answer) {
    surveyService.saveSurvey(answer.getSurveyId());
    answerService.saveAnswer(answer);
  }

  @Transactional
  @PostMapping(path = "saveAnswers", consumes = "application/json")
  public void saveAllAnswers(@RequestBody List<Answer> answerList) {
    Survey surveyId = answerList.get(0).getSurveyId();
    surveyService.saveSurvey(surveyId);
    for (Answer a : answerList) {
      a.setSurveyId(surveyId);
    }
    answerService.saveAllAnswers(answerList);
  }

}
