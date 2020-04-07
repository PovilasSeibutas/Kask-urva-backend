//package lt.daivospakalikai.academysurvey.applicationstatus;
//
//import lt.daivospakalikai.academysurvey.Captcha.CaptchaResponse;
//import lt.daivospakalikai.academysurvey.Captcha.CaptchaValidator;
//import lt.daivospakalikai.academysurvey.emailsend.EmailService;
//import lt.daivospakalikai.academysurvey.question.QuestionController;
//import lt.daivospakalikai.academysurvey.submission.Submission;
//import java.util.Date;
//
//import lt.daivospakalikai.academysurvey.submission.SubmissionService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/application-status")
//public class ApplicationStatusController {
//    private String subject = "IT Akademija: Aplikacijos statuso patikra";
//    private String text = "Nuoroda pasitikrinti jūsų aplikacijos statusą: ";
//private SubmissionId submissionId;
//
//    private static Logger log = LoggerFactory.getLogger(QuestionController.class);
//
//    @Autowired
//    private CaptchaValidator captchaValidator;
//
//    @Autowired
//    private ApplicationStatusRepository applicationStatusRepository;
//
//    @Autowired
//    private BCrypt bCrypt;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private SubmissionService submissionService;
//
//
//    @GetMapping("/{hashId}")
//    public Submission getAllSubmission(@PathVariable String hashId) throws Exception {
//       submissionId = applicationStatusRepository.checkIfHashcodeExists(hashId);
//       if (submissionId.getSubmissionId() == null) {
//           throw new Exception("Page not found");
//       }
//        return submissionService.getSubmissionById(submissionId.getSubmissionId());
//    }
//
//    @PostMapping
//    public void saveSubmissions(@RequestBody ApplicationStatusRequest applicationStatusRequest) throws Exception {
//        String submissionRecaptchaToken = applicationStatusRequest.getRecaptchaToken();
//        String submissionEmail = applicationStatusRequest.getEmail();
//        CaptchaResponse captchaResponse = captchaValidator.validateCaptcha(submissionRecaptchaToken);
//        if (!captchaResponse.getSuccess()) {
//            throw new Exception("Captcha is not valid");
//        }
//
//            submissionId = applicationStatusRepository.checkIfApplicationExists(submissionEmail);
//            Long currentDate = new Date().getTime() / 1000;
//            String date = Long.toString(currentDate);
//            String mash = submissionId.getSubmissionId() + "-" + date + "-" + submissionEmail;
//            String hashedMash = bCrypt.passwordEncoder().encode(mash);
//            hashedMash = hashedMash.replace('/', 'F');
//            String[] submissionEmails = {submissionEmail};
//            emailService.sendEmail(submissionEmails, subject, text + "http://pls-run.herokuapp.com/application-status/" + hashedMash);
//            applicationStatusRepository.saveApplicationHashcode(submissionId.getSubmissionId(), currentDate, hashedMash);
//
//    }
//
//}
