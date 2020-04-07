//package lt.daivospakalikai.academysurvey.authentication;
//
//import lt.daivospakalikai.academysurvey.applicationstatus.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class HelloResource {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;
//
//    @Autowired
//    private JwtUtil jwtTokenUtil;
//
//    @Autowired
//    private CustomValidation customValidation;
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        Date date = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
//
//        customValidation.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authenticationRequest.getUsername(),
//                        authenticationRequest.getPassword()
//                )
//        );
//
//        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails, date);
//
//        return ResponseEntity.ok(myUserDetailsService.makeResponse(jwt, authenticationRequest.getUsername(), date));
//    }
//}
//
