package lt.daivospakalikai.academysurvey.Sumbission;

import java.util.ArrayList;
import java.util.List;
import lt.daivospakalikai.academysurvey.Answer.AnswerService;
import lt.daivospakalikai.academysurvey.Survey.Survey;
import lt.daivospakalikai.academysurvey.Survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImp implements SubmissionService {

  @Autowired
  SurveyService surveyService;

  @Autowired
  AnswerService answerService;

  @Override
  public List<Submission> getAllSubmissions() {
    List<Submission> submissionList = new ArrayList<>();
    for (Survey s : surveyService.getAllSurveys()) {
      Submission submission = new Submission();
      submission.setId(s.getId());

      List<Question> questionList = new ArrayList<>();
      for (lt.daivospakalikai.academysurvey.Answer.Answer a : s.getAnswerList()) {
        Question submissionQuestion = new Question();
        Answer submissionAnswer = new Answer();

//        submissionAnswer.setId(a.getId());
        submissionAnswer.setAnswer(a.getAnswer());

//        submissionQuestion.setId(a.getQuestion().getId());
        submissionQuestion.setQuestion(a.getQuestion().getQuestion());
        submissionQuestion.setAnswer(submissionAnswer);

        questionList.add(submissionQuestion);
      }
      submission.setQuestions(questionList);
      submissionList.add(submission);

    }
    return submissionList;
  }

  @Override
  public void saveSubmission(Submission submission) {
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
