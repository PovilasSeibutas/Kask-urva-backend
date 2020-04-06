package lt.daivospakalikai.academysurvey.emailsend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sendmail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public void sendEmailsToQualifiedApplicants() {
        emailService.sendEmailsToQualifiedApplicants();
    }

}
