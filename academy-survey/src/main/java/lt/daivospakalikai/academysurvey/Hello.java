package lt.daivospakalikai.academysurvey;


public class Hello {


  private String name;
  private String surname;

  public Hello(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public Hello() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}
