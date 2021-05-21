package nl.avisi.tdd.app.webapp;

import nl.avisi.tdd.app.AuthenticationService;
import nl.avisi.tdd.app.UserRegistrationService;
import nl.avisi.tdd.app.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    @Bean
    public UserRegistrationService userRegistrationService(@Autowired UserRepository userRepository) {
        return new UserRegistrationService(userRepository);
    }

    @Bean
    public AuthenticationService authenticationService(@Autowired UserRepository userRepository) {
        return new AuthenticationService(userRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
