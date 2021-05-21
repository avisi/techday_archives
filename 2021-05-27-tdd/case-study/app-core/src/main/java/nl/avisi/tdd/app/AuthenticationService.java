package nl.avisi.tdd.app;

public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                             .map(user -> user.authenticate(password))
                             .orElse(false);
    }
}
