package lt.daivospakalikai.academysurvey.emailsend;

public class Email {

    private String answer;

    public Email() {
    }

    public Email(String text) {
        this.answer = text;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Email{" +
                "text='" + answer + '\'' +
                '}';
    }
}
