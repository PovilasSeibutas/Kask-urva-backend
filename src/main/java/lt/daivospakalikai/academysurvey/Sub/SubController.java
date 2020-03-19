package lt.daivospakalikai.academysurvey.Sub;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sub")
public class SubController {

  private static Logger log = LoggerFactory.getLogger(SubController.class);

  @Autowired
  SubService subService;

  @GetMapping
  public ResponseEntity<List<Submission>> getSurveys() {
    List<Submission> submissionList = subService.getAll();
    return new ResponseEntity<List<Submission>>(submissionList, HttpStatus.OK);
  }

}
