package lt.daivospakalikai.academysurvey.authentication;

import lt.daivospakalikai.academysurvey.admin.Admin;
import lt.daivospakalikai.academysurvey.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService  {

    @Autowired
    private AdminRepository adminRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = adminRepository.getAdmin(username);

        if(admin == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new User(username, admin.getPassword(), new ArrayList<>());

    }

    public Object makeResponse(String jwt, String username) {

        Admin admin = adminRepository.getAdmin(username);

        if(admin == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        AuthenticationResponse response = new AuthenticationResponse();
        response.setJwt(jwt);
        response.setAdminId(admin.getId());
        response.setName(admin.getName());
        response.setSurname(admin.getSurname());

        return response;

    }
}
