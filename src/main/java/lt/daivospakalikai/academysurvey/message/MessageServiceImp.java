package lt.daivospakalikai.academysurvey.message;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService {

  @Autowired
  MessageRepository messageRepository;

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
  public void replay(MessageOutbox messageOutbox) {
    messageRepository.replay(messageOutbox);
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
