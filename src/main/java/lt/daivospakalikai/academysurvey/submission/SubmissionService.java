package lt.daivospakalikai.academysurvey.submission;

import java.util.List;
import lt.daivospakalikai.academysurvey.filterandsort.SubmissionFilter;

public interface SubmissionService {

  List<Submission> getAllSubmissions();

  void saveSubmissions(List<Answer> answerList);

  void updateSubmissionStatus(SubmissionStatus submissionStatus);

  List<Submission> sortSubmissionsByNameAZ();

  List<Submission> sortSubmissionsByNameZA();

  Submission getSubmissionById(Integer id);

  List<Submission> filterAndSortSubmissions(SubmissionFilter submissionFilter);
}
