//package lt.daivospakalikai.academysurvey.authentication;
//
//import lt.daivospakalikai.academysurvey.admin.Admin;
//import lt.daivospakalikai.academysurvey.admin.AdminRepository;
//import lt.daivospakalikai.academysurvey.applicationstatus.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomValidation implements AuthenticationProvider {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Autowired
//    private BCrypt bcrypt;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        Admin admin = adminRepository.getAdmin(username);
//
//        if(admin == null) {
//            throw new BadCredentialsException("Authentication failed for " + username);
//        }
//
//        if (bcrypt.passwordEncoder().matches(password, admin.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(username, admin.getPassword());
//        } else {
//            throw new BadCredentialsException("Authentication failed for " + username);
//        }
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}