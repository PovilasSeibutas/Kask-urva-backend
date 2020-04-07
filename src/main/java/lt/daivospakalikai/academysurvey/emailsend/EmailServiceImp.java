package lt.daivospakalikai.academysurvey.emailsend;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lt.daivospakalikai.academysurvey.applicationstatus.ApplicationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImp {

  private JavaMailSender javaMailSender;
  private final String notificationSubject = "IT Akademija: Nauja aplikacija!";
  private final String notificationText = "Užregistruota nauja aplikacija į IT Akademiją. Ją galite peržiūrėti adresu:";
  private final String successSubject = "IT Akademija: Atranka sėkminga!";
  private final String successText = "Sveikiname, jūs sėkmingai praėjote atranką į IT Akademiją. Artimiausiu metu su Jumis susisieks mūsų personalo darbuotojas. Geros dienos!";

  @Autowired
  public EmailServiceImp(JavaMailSender javaMailSender) throws MailException {
    this.javaMailSender = javaMailSender;
  }

  @Autowired
  private ApplicationStatusRepository applicationStatusRepository;

  public void sendEmail(String[] emailAddress, String notificationSubject, String notificationText) {
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setTo(emailAddress);
    mail.setFrom("itacademyvilnius@gmail.com");
    mail.setSubject(notificationSubject);
    mail.setText(notificationText);

    javaMailSender.send(mail);
  }

  public String sendNotificationEmailToAdmin() {
    Admin admin = new Admin();
    try {
      sendEmail(admin.getAdminEmails(admin.emailProcess(AdminMails.values())), notificationSubject, notificationText);
    } catch (MailException e) {
      System.out.println("Error ocurred.");
    }

    return "Thank you for filling up the application form!";
  }


  public void sendEmailsToQualifiedApplicants() {
    String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    Pattern pattern = Pattern.compile(regex);
    List<SurveyId> surveyIdList = applicationStatusRepository.getSubmissionIdOfAcceptedUsers();
    String[] emailArray = new String[surveyIdList.size()];
    int i = surveyIdList.size();
    for (SurveyId surveyId : surveyIdList) {
      i--;
      int id = surveyId.getId();
      List<Email> emailList = applicationStatusRepository.getEmailFromFromUser(id);
      for (Email email : emailList) {
        String answer = email.getAnswer();
        Matcher matcher = pattern.matcher(answer);
        if (matcher.matches()) {
          emailArray[i] = answer;
        }
      }
    }
    sendEmail(emailArray, successSubject, successText);
    for (SurveyId surveyId : surveyIdList) {
      int id = surveyId.getId();
      applicationStatusRepository.saveSentStatus(id);
    }
  }
}
