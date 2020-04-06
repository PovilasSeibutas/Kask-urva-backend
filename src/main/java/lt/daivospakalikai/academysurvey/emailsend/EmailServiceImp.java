package lt.daivospakalikai.academysurvey.emailsend;

import lt.daivospakalikai.academysurvey.applicationstatus.ApplicationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class EmailServiceImp implements EmailService {

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

    @Override
    public void sendEmailsToQualifiedApplicants() {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Map<Integer, String> submissionMap = new HashMap<>();
        for (Integer i : applicationStatusRepository.getSubmissionIdOfAcceptedUsers()) {
            for (String s : applicationStatusRepository.getEmailFromUser(i)) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.matches()) {
                    submissionMap.put(i, s);
                }
            }
        }
        sendEmail(submissionMap.values().toArray(new String[0]), successSubject, successText);
        for (Integer surveyId : submissionMap.keySet()) {
            applicationStatusRepository.saveSentStatus(surveyId);
        }
    }
}
