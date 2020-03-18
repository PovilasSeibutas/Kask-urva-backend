package lt.daivospakalikai.academysurvey.Email_Send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    NotificationServiceImp notificationServiceImp;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/sign-up-success")
    public String signUpSuccess() {

        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setSurname("Admin");
        admin.setEmail("steelexx1997@gmail.com");

        try {
            notificationServiceImp.sendNotification(admin);
        } catch (MailException e) {
            System.out.println("Error ocurred.");
        }

        return "Thank you for filling up the application form!";
    }


}
