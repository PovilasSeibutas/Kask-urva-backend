package lt.daivospakalikai.academysurvey.Survey;

import java.util.List;
import java.util.Set;
import lt.daivospakalikai.academysurvey.Answer.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/surveys")
public class SurveyController {

  private static Logger log = LoggerFactory.getLogger(SurveyController.class);

  private SurveyService surveyService;

  @Autowired
  public SurveyController(SurveyService surveyService) {
    this.surveyService = surveyService;
  }

  @GetMapping
  public ResponseEntity<List<Survey>> getSurveys() {
    List<Survey> list = surveyService.getAllSurveys();
    return new ResponseEntity<List<Survey>>(list, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Set<Answer>> getAnswersBySurveyId(@PathVariable Integer id) {
    Set<Answer> answerSet = surveyService.getAnswersBySurveyId(id);
    return new ResponseEntity<Set<Answer>>(answerSet, HttpStatus.OK);
  }

  @PostMapping(consumes = "application/json")
  public void saveContactByPid(@RequestBody Survey survey) {
    surveyService.saveSurvey(survey);


  }

}
