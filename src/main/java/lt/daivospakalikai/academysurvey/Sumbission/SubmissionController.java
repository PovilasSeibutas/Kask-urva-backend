package lt.daivospakalikai.academysurvey.Sumbission;

import java.util.ArrayList;
import java.util.List;
import lt.daivospakalikai.academysurvey.Survey.Survey;
import lt.daivospakalikai.academysurvey.Survey.SurveyService;
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
@RequestMapping("/subbmisions")
public class SubmissionController {

  private static Logger log = LoggerFactory.getLogger(SubmissionController.class);

  @Autowired
  private SurveyService surveyService;

  @GetMapping
  public ResponseEntity<List<Submission>> getSubmissions() {
    List<Submission> submissionList = new ArrayList<>();
    for (Survey s : surveyService.getAllSurveys()) {
      Submission submission = new Submission();
      submission.setId(s.getId());

      List<Question> questionList = new ArrayList<>();
      for (lt.daivospakalikai.academysurvey.Answer.Answer a : s.getAnswerList()) {
        Question submissionQuestion = new Question();
        Answer submissionAnswer = new Answer();

        submissionAnswer.setId(a.getId());
        submissionAnswer.setAnswer(a.getAnswer());

        submissionQuestion.setId(a.getQuestion().getId());
        submissionQuestion.setQuestion(a.getQuestion().getQuestion());
        submissionQuestion.setAnswer(submissionAnswer);

        questionList.add(submissionQuestion);
      }
      submission.setQuestions(questionList);
      submissionList.add(submission);
    }
    return new ResponseEntity<List<Submission>>(submissionList, HttpStatus.OK);
  }
}
