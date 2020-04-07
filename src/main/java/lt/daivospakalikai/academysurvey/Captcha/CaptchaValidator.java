//package lt.daivospakalikai.academysurvey.Captcha;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class CaptchaValidator {
//
//    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
//
//    @Value("${google.recaptcha.secret}")
//    private String recaptchaSecret;
//
//    public CaptchaResponse validateCaptcha(String captchaResponse){
//        RestTemplate restTemplate = new RestTemplate();
//
//        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
//        requestMap.add("secret", recaptchaSecret);
//        requestMap.add("response", captchaResponse);
//
//        return restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, CaptchaResponse.class);
//    }
//
//}
