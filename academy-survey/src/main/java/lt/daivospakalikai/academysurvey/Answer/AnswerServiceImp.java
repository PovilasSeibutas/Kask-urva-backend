package lt.daivospakalikai.academysurvey.Answer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImp implements AnswerService {

  private AnswerRepository answerRepository;

  @Autowired
  private AnswerServiceImp(AnswerRepository answerRepository) {

    this.answerRepository = answerRepository;
  }

  @Override
  public List<Answer> getAllAnswers() {
    return answerRepository.findAll();
  }

  @Override
  public void saveAnswer(Answer answer) {
    answerRepository.save(answer);
  }


}
