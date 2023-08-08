package my.project.library.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/auth/login", "/auth/registration","/css/**", "/authors", "/error").permitAll()
                        .anyRequest().authenticated());

        http.formLogin((form) -> form
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/auth/login")
                        .failureUrl("/auth/login?error")
                        .loginProcessingUrl("/process_login")
                        .defaultSuccessUrl("/")
//                        .successForwardUrl("/")
                        .permitAll()
                        );

//        http.httpBasic(Customizer.withDefaults());

//        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }



    @Bean
    public DaoAuthenticationProvider authProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;

}

    private PasswordEncoder encoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return String.valueOf(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return String.valueOf(rawPassword).equals(encodedPassword);
            }
        };
    }


    }
