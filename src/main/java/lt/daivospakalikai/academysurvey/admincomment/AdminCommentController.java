package lt.daivospakalikai.academysurvey.admincomment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class AdminCommentController {

  @Autowired
  AdminCommentService adminCommentService;

  @PostMapping("/submission-comments")
  public List<AdminComment> getSubmmisionComments(@RequestBody AdminComment adminComment) {
    return adminCommentService.getComments(adminComment);
  }

  @PostMapping
  public void createComment(@RequestBody AdminComment adminComment) {
    adminCommentService.createComment(adminComment);
  }

  @PutMapping
  public void updateComment(@RequestBody AdminComment adminComment) {
    adminCommentService.updateComment(adminComment);
  }

  @DeleteMapping
  public void deleteComment(@RequestBody AdminComment adminComment) {
    adminCommentService.deleteComment(adminComment);
  }
}
