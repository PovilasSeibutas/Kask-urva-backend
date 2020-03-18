package lt.daivospakalikai.academysurvey.Sumbission;

import java.util.ArrayList;
import java.util.List;
import lt.daivospakalikai.academysurvey.Answer.AnswerService;
import lt.daivospakalikai.academysurvey.Survey.Survey;
import lt.daivospakalikai.academysurvey.Survey.SurveyService;
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
  private SurveyService surveyService;

  @Autowired
  private AnswerService answerService;

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

//  @PostMapping(consumes = "application/json")
//  public void saveSubbmision(@RequestBody Submission submission) {
//    surveyService.saveSurvey(new Survey());
//  }

  @Transactional
  @PostMapping(consumes = "application/json")
  public void saveSubmission(@RequestBody Submission submission) {
    List<lt.daivospakalikai.academysurvey.Answer.Answer> answerList = new ArrayList<>();
    for (lt.daivospakalikai.academysurvey.Sumbission.Question q : submission.getQuestions()) {
      lt.daivospakalikai.academysurvey.Answer.Answer answer = new lt.daivospakalikai.academysurvey.Answer.Answer();
      answer.setAnswer(q.getAnswer().getAnswer());

      lt.daivospakalikai.academysurvey.Question.Question question =
          new lt.daivospakalikai.academysurvey.Question.Question();
      question.setId(q.getId());
      answer.setQuestion(question);

      answer.setSurvey(new Survey());
      answerList.add(answer);
    }

    Survey surveyId = answerList.get(0).getSurvey();
    surveyService.saveSurvey(surveyId);
    for (lt.daivospakalikai.academysurvey.Answer.Answer a : answerList) {
      a.setSurvey(surveyId);
    }
    answerService.saveAllAnswers(answerList);
  }
}
