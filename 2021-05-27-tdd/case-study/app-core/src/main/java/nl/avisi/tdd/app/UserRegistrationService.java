package nl.avisi.tdd.app;

public class UserRegistrationService {
    private final UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerNewUser(String username, String password) {
        userRepository.save(User.createWithPassword(username, password));
    }
}
