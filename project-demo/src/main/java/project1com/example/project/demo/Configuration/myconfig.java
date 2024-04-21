package project1com.example.project.demo.Configuration;

import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import project1com.example.project.demo.UserDetailServiceImpl;

@EnableWebSecurity
@Configuration
public class myconfig {
    @Bean
    public UserDetailsService getuserdetail(){
        return new UserDetailServiceImpl();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
     return    new  BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.getuserdetail());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }
    //config  method with using database(daomethod)
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
         auth.authenticationProvider(authenticationProvider());



    }
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
      return   http.csrf(AbstractHttpConfigurer::disable ).authorizeHttpRequests(authz->authz

                                .requestMatchers("/admin/**")
               .hasRole("ADMIN")
               .requestMatchers("/user/**")
               .hasRole("USER")
                              .requestMatchers("/**")
               .permitAll().anyRequest().authenticated()
                 ).formLogin(formLogin->formLogin
              .loginPage("/Signin")
                      .loginProcessingUrl("/dologin")
                      .defaultSuccessUrl("/user/index")
                      .permitAll())
                .httpBasic(Customizer.withDefaults()).build();


    }



}