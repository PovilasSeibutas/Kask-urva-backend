package lt.daivospakalikai.academysurvey.Rest;

import java.util.List;
import lt.daivospakalikai.academysurvey.Answer.Answer;
import lt.daivospakalikai.academysurvey.Survey.Survey;
import lt.daivospakalikai.academysurvey.Survey.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/submissions")
public class Test {

    private static Logger log = LoggerFactory.getLogger(Test.class);

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping
    public List<Survey> getSurveys() {
        return surveyRepository.findByIdarea();
    }

}
