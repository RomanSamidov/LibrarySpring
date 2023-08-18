package my.project.library.config;



import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("roles", "languages");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers( "/authors").hasRole("admin")
                        .requestMatchers("/", "/auth/login", "/auth/registration","/css/**", "/authors", "/error").permitAll()
//                        .anyRequest().hasAnyRole("USER", "ADMIN", "LIBRARIAN"));
//                        .anyRequest().authenticated());
                        .anyRequest().permitAll());

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

        http.logout((form) -> form
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login"));

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


    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
