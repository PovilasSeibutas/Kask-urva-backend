package lt.daivospakalikai.academysurvey.Submission;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/submissions")
public class SubmissionController {

  private static Logger log = LoggerFactory.getLogger(SubmissionController.class);

  @Autowired
  SubmissionService submissionService;

  @GetMapping
  public ResponseEntity<List<Submission>> getAllSubmissions() {
    List<Submission> submissionList = submissionService.getAllSubmissions();
    return new ResponseEntity<List<Submission>>(submissionList, HttpStatus.OK);
  }

  @PostMapping
  public void saveSubmisions(@RequestBody List<Answer> answerList) {
    submissionService.saveSubmissions(answerList);
  }

}
