package lt.daivospakalikai.academysurvey.adminComment;

import java.util.List;

public interface AdminCommentService {

  List<AdminComment> getComments(AdminComment adminComment);

  void updateComment(AdminComment adminComment);

  void deleteComment(AdminComment adminComment);

  void createComment(AdminComment adminComment);

}
