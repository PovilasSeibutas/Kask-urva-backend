package lt.daivospakalikai.academysurvey.Sumbission;

import java.util.List;
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
@RequestMapping("/subbmisions")
public class SubmissionController {

  private static Logger log = LoggerFactory.getLogger(SubmissionController.class);

  @Autowired
  private SubmissionService submissionService;

  @GetMapping
  public ResponseEntity<List<Submission>> getSubmissions() {
    return new ResponseEntity<List<Submission>>(submissionService.getAllSubmissions(), HttpStatus.OK);
  }

  @Transactional
//  @PostMapping(consumes = "application/json")
  public void saveSubmission(@RequestBody Submission submission) {
    submissionService.saveSubmission(submission);
  }
}
