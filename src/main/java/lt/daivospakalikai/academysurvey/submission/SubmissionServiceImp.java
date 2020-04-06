package lt.daivospakalikai.academysurvey.submission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lt.daivospakalikai.academysurvey.emailsend.EmailService;
import lt.daivospakalikai.academysurvey.filterandsort.SubmissionFilter;
import lt.daivospakalikai.academysurvey.survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImp implements SubmissionService {

  @Autowired
  SubmissionRepository submissionRepository;
  @Autowired
  EmailService emailService;
  @Autowired
  SurveyService surveyService;

  @Override
  public List<Submission> getAllSubmissions() {
    Map<Integer, Submission> submissionMap = new TreeMap<>();
    return getDataFromDB(submissionMap, submissionRepository.getAll());
  }

  @Override
  public void saveSubmissions(Submission submission) {
    submissionRepository.saveSubmissions(submission.getAnswers(), surveyService.createSurvey(submission.getGdprId()));
    emailService.sendNotificationEmailToAdmin();
  }

  @Override
  public void updateSubmissionStatus(SubmissionStatus submissionStatus) {
    submissionRepository.updateSubmissionStatus(submissionStatus);
  }

  @Override
  public List<Submission> sortSubmissionsByNameAZ() {
    Map<Integer, Submission> submissionMap = new LinkedHashMap<>();
    return getDataFromDB(submissionMap, submissionRepository.sortSubmissionsByNameAZ());
  }

  @Override
  public List<Submission> sortSubmissionsByNameZA() {
    Map<Integer, Submission> submissionMap = new LinkedHashMap<>();
    return getDataFromDB(submissionMap, submissionRepository.sortSubmissionsByNameZA());
  }

  @Override
  public Submission getSubmissionById(Integer id) {
    Map<Integer, Submission> submissionMap = new TreeMap<>();
    return getDataFromDB(submissionMap, submissionRepository.getSubmissionById(id)).get(0);
  }

  @Override
  public List<Submission> filterAndSortSubmissions(SubmissionFilter submissionFilter) {
    Map<Integer, Submission> submissionMap = new LinkedHashMap<>();
    return getDataFromDB(submissionMap, submissionRepository.filterAndSortSubmissions(submissionFilter));
  }

  @Override
  public void deleteSubmission(List<Integer> submissionList) {
    submissionRepository.deleteSubmission(submissionList);
  }

  @Override
  public void deleteSubmissionByDate(List<Long> timeStampList) {
    submissionRepository.deleteSubmissionsByDate(timeStampList);
  }

  private ArrayList<Submission> getDataFromDB(Map<Integer, Submission> map,
      List<SubmissionForm> submissionFormList) {
    for (SubmissionForm s : submissionFormList) {
      if (map.containsKey(s.getId())) {
        map.get(s.getId()).getAnswers()
            .add(s.createNewAnswer());
      } else {
        map.put(s.getId(),
            new Submission(s.getId(), s.getStatus(), s.getGdprId(), s.getTimeStamp(),
                new ArrayList(Arrays.asList(s.createNewAnswer()))
                , null));
      }
    }
    return new ArrayList<>(map.values());
  }

}
