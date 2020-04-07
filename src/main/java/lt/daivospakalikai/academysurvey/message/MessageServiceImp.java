package lt.daivospakalikai.academysurvey.message;

import java.util.List;

import lt.daivospakalikai.academysurvey.emailsend.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService {
  private String subject = "IT Akademija";

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  EmailService emailService;

  @Override
  public List<Message> getAllMessages() {
    return messageRepository.getAllMessages();
  }

  @Override
  public void createMessage(Message message) {
    messageRepository.createMessage(message);
  }

  @Override
  public List<MessageOutbox> getAllReplays() {
    return messageRepository.getAllReplays();
  }

  @Override
  public void replay(MessageOutbox messageOutbox) throws Exception {
    try {
    messageRepository.replay(messageOutbox);
      String[] email = {messageRepository.getUsersEmail(messageOutbox.getMessageId())};
      String message = messageRepository.getMessageText(messageOutbox.getMessageId());
      emailService.sendEmail(email, subject, message);
    } catch (Exception e) {
      throw new Exception("Something went wrong.");
    }
  }

  @Override
  public void deleteMessage(Message message) {
    messageRepository.deleteMessage(message);
  }

  @Override
  public void deleteReplay(MessageOutbox messageOutbox) {
    messageRepository.deleteRelay(messageOutbox);
  }

  @Override
  public void updateMessageStatus(Message message) {
    messageRepository.updateMessageStatus(message);
  }
}