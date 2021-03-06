package lt.daivospakalikai.academysurvey.applicationstatus;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCrypt {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
