package lt.daivospakalikai.academysurvey.Email_Send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImp implements NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationServiceImp(JavaMailSender javaMailSender) throws MailException {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Admin admin) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(admin.getEmail());
        mail.setFrom("steelexx1997@gmail.com");
        mail.setSubject("IT Akademija: Nauja aplikacija!");
        mail.setText("Užregistruota nauja aplikacija į IT Akademiją. Ją galite peržiūrėti adresu: www.localhost4200/auth");

        javaMailSender.send(mail);
    }
}
