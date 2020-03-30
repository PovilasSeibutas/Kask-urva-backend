package lt.daivospakalikai.academysurvey.question;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImp implements QuestionService {

  @Autowired
  private QuestionRepository questionRepository;


  @Override
  public List<Question> getAllQuestions() {
    List<Question> questionList = new ArrayList<>();
    for (QuestionFromDB q : questionRepository.getAllQuestions()) {
      OptionToJsonConverter optionToJsonConverter = new OptionToJsonConverter();
      if (optionToJsonConverter.convertToEntityAttribute(q.getOptionJson()) != null) {
        questionList.add(new Question(q.getId(), q.getQuestion(),
            optionToJsonConverter.convertToEntityAttribute(q.getOptionJson())));
      }
    }
    return questionList;
  }

  @Override
  public void saveQuestion(Question question) {
    questionRepository.createQuestion(question);
  }

}
