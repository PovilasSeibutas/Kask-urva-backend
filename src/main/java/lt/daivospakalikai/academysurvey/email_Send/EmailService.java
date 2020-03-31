package lt.daivospakalikai.academysurvey.email_Send;

public interface EmailService {
    void sendEmail(String[] emailAddress, String notificationSubject, String notificationText);
    String sendNotificationEmailToAdmin();
}
