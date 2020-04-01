package lt.daivospakalikai.academysurvey.gdpr;

import java.util.List;
import lt.daivospakalikai.academysurvey.question.Question;
import lt.daivospakalikai.academysurvey.question.QuestionController;
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
@RequestMapping("/agreements")
public class GdprConroller {

  private static Logger log = LoggerFactory.getLogger(QuestionController.class);

  @Autowired
  GdprService gdprService;

  @GetMapping
  public ResponseEntity<List<Gdpr>> getAllGdprAgreements() {
    List<Gdpr> list = gdprService.getAllGdrpAgreements();
    return new ResponseEntity<List<Gdpr>>(list, HttpStatus.OK);
  }

  @PostMapping
  public void createNewGdprAgreement(@RequestBody Gdpr gdpr) {
    gdprService.createGdpr(gdpr);
  }

  @PostMapping("/gdpr")
  private Gdpr getGdprAgreementById(@RequestBody Gdpr gdpr) {
    return gdprService.getGdprById(gdpr);
  }

}
