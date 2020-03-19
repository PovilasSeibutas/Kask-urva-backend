package lt.daivospakalikai.academysurvey.Sub;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubSurveyImp implements SubService {

  @Autowired
  SubRepository subRepository;

  @Override
  public List<Submission> getAll() {
    List<Sub> subList = subRepository.getAll();
    Set<Submission> submissionSet = new HashSet<>();
    List<Submission> submissionList = new ArrayList<>();
    for (Sub s : subList) {
      Submission submission = new Submission();
      submission.setId(s.getId());
      submissionSet.add(submission);
    }

    for (Submission submission : submissionSet) {
      List<Answer> answerList = new ArrayList<>();
      for (Sub sub : subList) {
        if (submission.getId().equals(sub.getId())) {
          Answer answer = new Answer();
          answer.setQuestionId(sub.getQuestionId());
          answer.setQuestion(sub.getQuestion());
          answer.setAnswerId(sub.getAnswerId());
          answer.setAnswer(sub.getAnswer());
          answerList.add(answer);
          submission.setAnswers(answerList);
        }
      }
      submissionList.add(submission);
    }
    return submissionList;
  }
}
