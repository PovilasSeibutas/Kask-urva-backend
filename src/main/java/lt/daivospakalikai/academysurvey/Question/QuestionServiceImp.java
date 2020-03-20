package lt.daivospakalikai.academysurvey.Question;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImp implements QuestionService {

  @Autowired
  private QuestionRepository questionRepository;

  @Override
  public List<Question> getAllQuestions() {
    return questionRepository.findAll();
  }

  @Override
  public void saveQuestion(Question question) {
    questionRepository.save(question);
  }

}
