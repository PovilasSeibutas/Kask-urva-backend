//package lt.daivospakalikai.academysurvey.authentication;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//  @Autowired
//  private CustomValidation authProvider;
//
//  @Autowired
//  private JwtRequestFilter jwtRequestFilter;
//
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.authenticationProvider(authProvider);
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//            .authorizeRequests()
//            .antMatchers("/authenticate").permitAll()
//            .antMatchers(HttpMethod.POST, "/submissions").permitAll()
//            .antMatchers(HttpMethod.GET, "/questions").permitAll()
//            .antMatchers((HttpMethod.POST), "/messages").permitAll()
//            .antMatchers("/application-status").permitAll()
//            .antMatchers("/application-status/**").permitAll()
//            .antMatchers(HttpMethod.POST, "/agreements/gdpr").permitAll()
//            .anyRequest().authenticated()
//            .and().sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//  }
//
//  @Override
//  @Bean
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return NoOpPasswordEncoder.getInstance();
//  }
//}
