package lt.daivospakalikai.academysurvey.Submission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lt.daivospakalikai.academysurvey.Survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SubmissionServiceImp implements SubmissionService {

  @Autowired
  SubmissionRepository submissionRepository;

  @Autowired
  SurveyService surveyService;

  @Override
  public List<Submission> getAllSubmissions() {
    Map<Integer, Submission> submissionMap = new TreeMap<>();
    for (SubmissionForm s : submissionRepository.getAll()) {
      if (submissionMap.containsKey(s.getId())) {
        submissionMap.get(s.getId()).getAnswers()
            .add(s.createNewAnswer());
      } else {
        submissionMap.put(s.getId(),
            new Submission(s.getId(), new ArrayList(Arrays.asList(s.createNewAnswer()))));
      }
    }
    return new ArrayList<>(submissionMap.values());
  }

  @Override
  public void saveSubmissions(@RequestBody List<Answer> answerList) {
    submissionRepository.saveSubmissions(answerList);
  }

  @Override
  public Integer getNewSumbisionId() {
    return surveyService.createSurvey();
  }


}
