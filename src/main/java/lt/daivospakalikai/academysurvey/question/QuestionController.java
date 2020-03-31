package lt.daivospakalikai.academysurvey.question;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/questions")
public class QuestionController {

  private static Logger log = LoggerFactory.getLogger(QuestionController.class);

  @Autowired
  private QuestionService questionService;

  @GetMapping
  public ResponseEntity<List<Question>> getAllQuestions() {
    List<Question> list = questionService.getAllQuestions();
    return new ResponseEntity<List<Question>>(list, HttpStatus.OK);
  }

  @PostMapping
  public void saveQuestion(@RequestBody Question question) {
    questionService.saveQuestion(question);
  }

  @PutMapping
  public void updateQuestion(@RequestBody Question question) {
    questionService.updateQuestion(question);
  }

  @DeleteMapping
  public void deleteQuestion(@RequestBody Question question) {
    questionService.deleteQuestion(question);
  }

}
