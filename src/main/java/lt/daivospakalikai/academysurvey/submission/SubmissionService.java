package lt.daivospakalikai.academysurvey.submission;

import java.util.List;
import lt.daivospakalikai.academysurvey.filterandsort.SubmissionFilter;

public interface SubmissionService {

  List<Submission> getAllSubmissions();

  void saveSubmissions(Submission submission);

  void updateSubmissionStatus(SubmissionStatus submissionStatus);

  Submission getSubmissionById(Integer id);

  List<Submission> filterAndSortSubmissions(SubmissionFilter submissionFilter);

  void deleteSubmission(List<Integer> submissionList);

  void deleteSubmissionByDate(List<Long> timeStampList);
}
