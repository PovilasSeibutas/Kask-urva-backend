package lt.daivospakalikai.academysurvey.Submission;

import java.util.List;

public interface SubmissionService {

  List<Submission> getAllSubmissions();

  void saveSubmissions(List<Answer> answerList);

  Integer getNewSumbisionId();

  void updateSubmissionStatus(SubmissionStatus submissionStatus);

}
