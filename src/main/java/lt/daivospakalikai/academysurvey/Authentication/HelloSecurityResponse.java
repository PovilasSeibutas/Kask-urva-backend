package lt.daivospakalikai.academysurvey.Authentication;

public class HelloSecurityResponse {

    private final String text;

    public HelloSecurityResponse(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
