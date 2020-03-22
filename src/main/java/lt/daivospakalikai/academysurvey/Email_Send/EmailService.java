package lt.daivospakalikai.academysurvey.Email_Send;

public interface EmailService {
    void sendEmail(String[] emailAddress, String notificationSubject, String notificationText);
    String sendNotificationEmailToAdmin();
}
