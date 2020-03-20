/*
package lt.daivospakalikai.academysurvey.Email_Send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final String notificationSubject = "IT Akademija: Nauja aplikacija!";
    private final String notificationText = "Užregistruota nauja aplikacija į IT Akademiją. Ją galite peržiūrėti adresu:";

    @Autowired
    NotificationServiceImp notificationServiceImp;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/sign-up-success")
    public String signUpSuccess() {
        Admin admin = new Admin();
        try {
            notificationServiceImp.sendNotification(admin.getAdminEmails(admin.emailProcess(AdminMails.values())), notificationSubject, notificationText);
        } catch (MailException e) {
            System.out.println("Error ocurred.");
        }

        return "Thank you for filling up the application form!";
    }
}

*/
