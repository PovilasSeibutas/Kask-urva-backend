package lt.daivospakalikai.academysurvey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//  @GetMapping
//  public String index() {
//    return "Greetings from Spring Boot!";
//  }

  @GetMapping(path = "/index")
  public Hello index() {
    Hello newHello = new Hello("Hello", "Goodboye");
    return newHello;
  }

}
