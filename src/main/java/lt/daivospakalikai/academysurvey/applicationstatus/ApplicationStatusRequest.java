package lt.daivospakalikai.academysurvey.applicationstatus;

public class ApplicationStatusRequest {
    private String email;
    private String recaptchaToken;

    public ApplicationStatusRequest() {
    }

    public ApplicationStatusRequest(String email, String recaptchaToken) {
        this.email = email;
        this.recaptchaToken = recaptchaToken;
    }

    public String getEmail() {
        return email;
    }

    public String getRecaptchaToken() {
        return recaptchaToken;
    }
}
