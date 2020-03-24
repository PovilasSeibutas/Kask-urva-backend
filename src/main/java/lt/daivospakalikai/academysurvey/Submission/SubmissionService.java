package lt.daivospakalikai.academysurvey.Submission;

import java.util.List;

public interface SubmissionService {

  List<Submission> getAllSubmissions();

  void saveSubmissions(List<Answer> answerList);

  Integer getNewSubmissionId();

  void updateSubmissionStatus(SubmissionStatus submissionStatus);

  List<Submission> sortSubmissionsByNameAZ();

  List<Submission> sortSubmissionsByNameZA();


}
