package lt.daivospakalikai.academysurvey.emailsend;

public class SurveyId {

    private Integer id;

    public SurveyId() {
    }

    public SurveyId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SurveyId{" +
                "id=" + id +
                '}';
    }
}