package lt.daivospakalikai.academysurvey.emailsend;

public interface EmailService {
    void sendEmail(String[] emailAddress, String notificationSubject, String notificationText);
    String sendNotificationEmailToAdmin();
    void sendEmailsToQualifiedApplicants();
}
