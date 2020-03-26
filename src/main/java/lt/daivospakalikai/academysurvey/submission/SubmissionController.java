package lt.daivospakalikai.academysurvey.submission;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public void saveSubmisions(@RequestBody Submission submission) {
    submissionService.saveSubmissions(submission.getAnswers());
  }

  @PutMapping
  public void updateSumbssionStatus(@RequestBody SubmissionStatus submissionStatus) {
    submissionService.updateSubmissionStatus(submissionStatus);
  }

  @GetMapping("/sorted-submissions-az")
  public ResponseEntity<List<Submission>> getSortSubmisionsByNameAZ() {
    List<Submission> submissionList = submissionService.sortSubmissionsByNameAZ();
    return new ResponseEntity<List<Submission>>(submissionList, HttpStatus.OK);
  }

  @GetMapping("/sorted-submissions-za")
  public ResponseEntity<List<Submission>> getSortSubmisionsByNameZA() {
    List<Submission> submissionList = submissionService.sortSubmissionsByNameZA();
    return new ResponseEntity<List<Submission>>(submissionList, HttpStatus.OK);
  }

  //for testing purposes
  @GetMapping("/{id}")
  public Submission getSubmissionById(@PathVariable Integer id) {
    return submissionService.getSubmissionById(id);
  }

  @PostMapping("/filter")
  public List<Submission> filterSubmissions(@RequestBody List<String> filterString){
    return submissionService.filterSubmissions(filterString);
  }

}
