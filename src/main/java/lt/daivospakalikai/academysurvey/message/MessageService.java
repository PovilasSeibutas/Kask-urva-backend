package lt.daivospakalikai.academysurvey.message;

import java.util.List;

public interface MessageService {

  List<Message> getAllMessages();

  void createMessage(Message message);

  List<MessageOutbox> getAllReplays();

  void replay(MessageOutbox messageOutbox) throws Exception;

  void deleteMessage(Message message);

  void deleteReplay(MessageOutbox messageOutbox);

}
