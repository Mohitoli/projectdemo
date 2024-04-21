package student.com.example.StudentERP.AuthorizationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import student.com.example.StudentERP.myconfig.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class Authconfig {

   @Bean
    public UserDetailServiceImpl userDetailService(){
       return new UserDetailServiceImpl();
   }
   @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
       return new BCryptPasswordEncoder();

   }
   public DaoAuthenticationProvider AuthenticationProvider(){
       DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(this.userDetailService());
    daoAuthenticationProvider.setPasswordEncoder(this.bCryptPasswordEncoder());
    return daoAuthenticationProvider;
   }
public void configure(AuthenticationManagerBuilder auth) throws Exception{
       auth.authenticationProvider(AuthenticationProvider());
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth->auth
               .requestMatchers("/admin/**")
               .hasRole("ADMIN")
               .requestMatchers("/student/**")
               .hasRole("STUDENT")
               .requestMatchers("/**")
               .permitAll()
                .anyRequest().authenticated())
               .formLogin(formlogin->formlogin
                       .loginPage("/Signin")
                       .loginProcessingUrl("/dologin")
                       .defaultSuccessUrl("/student/index")
                       .permitAll())
                .httpBasic(Customizer.withDefaults()).build();
}




}
