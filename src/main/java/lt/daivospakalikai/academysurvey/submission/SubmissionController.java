package lt.daivospakalikai.academysurvey.submission;

import java.util.List;
import lt.daivospakalikai.academysurvey.Captcha.CaptchaResponse;
import lt.daivospakalikai.academysurvey.Captcha.CaptchaValidator;
import lt.daivospakalikai.academysurvey.filterandsort.SubmissionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  @Autowired
  CaptchaValidator captchaValidator;

  @GetMapping
  public ResponseEntity<List<Submission>> getAllSubmissions() {
    List<Submission> submissionList = submissionService.getAllSubmissions();
    return new ResponseEntity<List<Submission>>(submissionList, HttpStatus.OK);
  }

  @PostMapping
  public void saveSubmissions(@RequestBody Submission submission) throws Exception {
    CaptchaResponse captchaResponse = captchaValidator.validateCaptcha(submission.getRecaptchaToken());
    if (!captchaResponse.getSuccess()) {
      throw new Exception("Captcha is not valid");
    }
    submissionService.saveSubmissions(submission);
  }

  @PutMapping
  public void updateSubmissionStatus(@RequestBody SubmissionStatus submissionStatus) {
    submissionService.updateSubmissionStatus(submissionStatus);
  }

  @DeleteMapping
  public void deleteSubmission(@RequestBody List<Integer> submissionIdList) {
    submissionService.deleteSubmission(submissionIdList);
  }

  @DeleteMapping("/deleteByDate")
  public Integer deleteSubmissionsByDate(@RequestBody List<Long> timeStampList) {
    return submissionService.deleteSubmissionByDate(timeStampList);
  }

  //for testing purposes
//  @GetMapping("/{id}")
//  public Submission getSubmissionById(@PathVariable Integer id) {
//    return submissionService.getSubmissionById(id);
//  }

  @PostMapping("/filter")
  public List<Submission> filterAndSortSubmissions(@RequestBody SubmissionFilter submissionFilter) {
    return submissionService.filterAndSortSubmissions(submissionFilter);
  }

}
