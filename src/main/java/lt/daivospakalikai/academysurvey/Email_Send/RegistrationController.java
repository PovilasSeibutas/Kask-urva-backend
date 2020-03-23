package lt.daivospakalikai.academysurvey.Email_Send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    EmailServiceImp emailServiceImp;

    //Controller for testing

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/sign-up-success")
    public String signUpSuccess() {
        try {
            emailServiceImp.sendNotificationEmailToAdmin();
        } catch (MailException e) {
            System.out.println("Error ocurred.");
        }

        return "Thank you for filling up the application form!";
    }
}

