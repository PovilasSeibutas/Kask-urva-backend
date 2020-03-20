package lt.daivospakalikai.academysurvey.Submission;

import java.util.List;

public interface SubmissionService {

  List<Submission> getAllSubmission();

  void saveSubmission(Answer answer);

}
