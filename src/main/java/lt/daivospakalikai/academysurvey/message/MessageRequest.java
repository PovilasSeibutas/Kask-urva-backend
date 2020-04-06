package lt.daivospakalikai.academysurvey.message;

public class MessageRequest {

    private String email;
    private String message;
    private String recaptchaToken;

    public MessageRequest(String email, String message, String recaptchaToken) {
        this.email = email;
        this.message = message;
        this.recaptchaToken = recaptchaToken;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getRecaptchaToken() { return recaptchaToken; }

}