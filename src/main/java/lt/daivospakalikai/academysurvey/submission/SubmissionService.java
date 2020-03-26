package lt.daivospakalikai.academysurvey.submission;

import java.util.List;

public interface SubmissionService {

  List<Submission> getAllSubmissions();

  void saveSubmissions(List<Answer> answerList);

  void updateSubmissionStatus(SubmissionStatus submissionStatus);

  List<Submission> sortSubmissionsByNameAZ();

  List<Submission> sortSubmissionsByNameZA();

  Submission getSubmissionById(Integer id);

  List<Submission> filterSubmissions(List<String> filterList);
}
