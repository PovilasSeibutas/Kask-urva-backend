package lt.daivospakalikai.academysurvey.Sumbission;

import java.util.List;

public interface SubmissionService {

  List<Submission> getAllSubmissions();

  void saveSubmission(Submission submission);

}
