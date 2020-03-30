package lt.daivospakalikai.academysurvey.question;

public class QuestionFromDB {

  private Integer id;
  private String optionJson;
  private String question;

  public QuestionFromDB() {
  }

  public QuestionFromDB(Integer id) {
    this.id = id;
  }

  public QuestionFromDB(Integer id, String optionJson, String question) {
    this.id = id;
    this.optionJson = optionJson;
    this.question = question;
  }

  public Integer getId() {
    return id;
  }

  public String getOptionJson() {
    return optionJson;
  }

  public String getQuestion() {
    return question;
  }

}
