package lt.daivospakalikai.academysurvey.Email_Send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImp implements NotificationService {
    private JavaMailSender javaMailSender;
    private final String notificationSubject = "IT Akademija: Nauja aplikacija!";
    private final String notificationText = "Užregistruota nauja aplikacija į IT Akademiją. Ją galite peržiūrėti adresu:";

    @Autowired
    public NotificationServiceImp(JavaMailSender javaMailSender) throws MailException {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(String[] emailAddress, String notificationSubject, String notificationText) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailAddress);
        mail.setFrom("itacademyvilnius@gmail.com");
        mail.setSubject(notificationSubject);
        mail.setText(notificationText);

        javaMailSender.send(mail);
    }
    public String signUpSuccess() {
        Admin admin = new Admin();
        try {
            sendNotification(admin.getAdminEmails(admin.emailProcess(AdminMails.values())), notificationSubject, notificationText);
        } catch (MailException e) {
            System.out.println("Error ocurred.");
        }

        return "Thank you for filling up the application form!";
    }
}
