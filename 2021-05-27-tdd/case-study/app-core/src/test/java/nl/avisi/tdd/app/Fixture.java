package nl.avisi.tdd.app;

public class Fixture {
    private final UserRepository userRepository = new InMemoryUserRepository();
    private final UserRegistrationService userRegistrationService = new UserRegistrationService(userRepository);
    private final AuthenticationService authenticationService = new AuthenticationService(userRepository);

    public void registerNewUser(String username, String password) {
        userRegistrationService.registerNewUser(username, password);
    }

    public boolean authenticate(String username, String password) {
        return authenticationService.authenticate(username, password);
    }
}
