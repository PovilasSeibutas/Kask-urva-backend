package lt.daivospakalikai.academysurvey.gdpr;

public class Gdpr {

  private Integer id;
  private String agreement;

  public Gdpr() {
  }

  public Gdpr(Integer id, String agreement) {
    this.id = id;
    this.agreement = agreement;
  }

  public Integer getId() {
    return id;
  }

  public String getAgreement() {
    return agreement;
  }
}
