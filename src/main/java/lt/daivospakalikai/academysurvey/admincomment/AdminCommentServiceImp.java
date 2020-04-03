package lt.daivospakalikai.academysurvey.admincomment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCommentServiceImp implements AdminCommentService {

  @Autowired
  AdminCommentRepository adminCommentRepository;

  @Override
  public List<AdminCommentResponse> getComments(AdminComment adminComment) {
    return adminCommentRepository.getSumbissionComments(adminComment);
  }

  @Override
  public void updateComment(AdminComment adminComment) {
    adminCommentRepository.updateComment(adminComment);
  }

  @Override
  public void deleteComment(AdminComment adminComment) {
    adminCommentRepository.deleteComment(adminComment);
  }

  @Override
  public void createComment(AdminComment adminComment) {
    adminCommentRepository.createComment(adminComment);
  }
}
