package lt.daivospakalikai.academysurvey.Answer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImp implements AnswerService {

  @Autowired
  private AnswerRepository answerRepository;

  @Override
  public List<Answer> getAllAnswers() {
    return answerRepository.findAll();
  }

  @Override
  public void saveAnswer(Answer answer) {
    answerRepository.save(answer);
  }

  @Override
  public void saveAllAnswers(List<Answer> answerList) {
    answerRepository.saveAll(answerList);
  }


}
