package lt.daivospakalikai.academysurvey.Email_Send;

public interface NotificationService {
    void sendNotification(String[] emailAddress, String notificationSubject, String notificationText);
}
