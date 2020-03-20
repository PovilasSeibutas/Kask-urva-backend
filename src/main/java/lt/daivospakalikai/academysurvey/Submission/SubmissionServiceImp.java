package lt.daivospakalikai.academysurvey.Submission;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SubmissionServiceImp implements SubmissionService {

  @Autowired
  SubmissionRepository submissionRepository;

  @Override
  public List<Submission> getAllSubmission() {
    Map<Integer, Submission> submissionMap = new TreeMap<>();
    for (Sub s : submissionRepository.getAll()) {
      if (submissionMap.containsKey(s.getId())) {
        submissionMap.get(s.getId()).getAnswers()
            .add(new Answer(s.getQuestionId(), s.getQuestion(), s.getAnswerId(), s.getAnswer()));
      } else {
        submissionMap.put(s.getId(),
            new Submission(s.getId(), new ArrayList<Answer>() {
              {
                new Answer(s.getQuestionId(), s.getQuestion(), s.getAnswerId(), s.getAnswer());
              }
            }));
      }
    }
    return new ArrayList<>(submissionMap.values());
  }

  @Override
  public void saveSubmission(@RequestBody Answer answer) {
    submissionRepository.saveSubmission(answer);
  }
}
