package lt.daivospakalikai.academysurvey.Answer;

import java.util.List;
import java.util.Set;
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

  @Override
  public void saveAllAnswers(Set<Answer> answerSet) {
    answerRepository.saveAll(answerSet);
  }

//  @Override
//  public Set<Answer> saveAllAnswers(Set<Answer> answerSet) {
//    Set<Answer> response = (Set<Answer>) answerRepository.saveAll(answerSet);
//    return response;
//  }

//  @Transactional
//  public List<Student> saveAllStudent(List<Student> studentList) {
//    List<Student> response = (List<Student>) studentRepository.saveAll(studentList);
//    return response;
//  }

}
