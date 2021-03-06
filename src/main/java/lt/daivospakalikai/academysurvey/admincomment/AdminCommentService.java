package lt.daivospakalikai.academysurvey.admincomment;

import java.util.List;

public interface AdminCommentService {

  List<AdminCommentResponse> getComments(AdminComment adminComment);

  void updateComment(AdminComment adminComment);

  void deleteComment(AdminComment adminComment);

  void createComment(AdminComment adminComment);

}
