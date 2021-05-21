package nl.avisi.tdd.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    public final List<User> users = new ArrayList<User>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.stream()
                    .filter(user -> user.getUsername().equals(username))
                    .findFirst();
    }
}
