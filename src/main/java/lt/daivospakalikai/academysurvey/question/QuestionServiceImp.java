package lt.daivospakalikai.academysurvey.question;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImp implements QuestionService {

  @Autowired
  private QuestionRepository questionRepository;


  @Override
  public List<Question> getAllQuestions() {
    return questionRepository.getAllQuestions();
  }

  @Override
  public void saveQuestion(Question question) {
    questionRepository.createQuestion(question);
  }

  @Override
  public void updateQuestion(Question question) {
    questionRepository.updateQuestion(question);
  }

  @Override
  public void deleteQuestion(Question question) {
    questionRepository.deleteQuestion(question);
  }

}
