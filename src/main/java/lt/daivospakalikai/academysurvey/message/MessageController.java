package lt.daivospakalikai.academysurvey.message;

import java.util.List;

//import lt.daivospakalikai.academysurvey.Captcha.CaptchaResponse;
//import lt.daivospakalikai.academysurvey.Captcha.CaptchaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/messages")
public class MessageController {

  @Autowired
  MessageService messageService;

//  @Autowired
//  private CaptchaValidator captchaValidator;

  @GetMapping
  public List<Message> getAllMessages() {
    return messageService.getAllMessages();
  }

  @PostMapping
  public void sendMessage(@RequestBody MessageRequest messageRequest) throws Exception {
    String submissionRecaptchaToken = messageRequest.getRecaptchaToken();
//    CaptchaResponse captchaResponse = captchaValidator.validateCaptcha(submissionRecaptchaToken);
//    if (!captchaResponse.getSuccess()) {
//      throw new Exception("Captcha is not valid");
//    }

    Message message = new Message(messageRequest.getEmail(), messageRequest.getMessage());

    messageService.createMessage(message);
  }

  @GetMapping("/replays")
  public List<MessageOutbox> getAllReplays() {
    return messageService.getAllReplays();
  }

  @PostMapping("/replays")
  public void replayMessage(@RequestBody MessageOutbox messageOutbox) throws Exception {
    messageService.replay(messageOutbox);
  }

  @DeleteMapping
  public void deleteMessage(@RequestBody Message message) {
    messageService.deleteMessage(message);
  }

  @DeleteMapping("deleteReplay")
  public void deleteReplay(@RequestBody MessageOutbox messageOutbox) {
    messageService.deleteReplay(messageOutbox);
  }

  @PutMapping
  public void updateMessageSatuts(@RequestBody Message message) {
    messageService.updateMessageStatus(message);
  }

}