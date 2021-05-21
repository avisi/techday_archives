package nl.avisi.tdd.app.webapp.repository;

import nl.avisi.tdd.app.SHA256Hash;
import nl.avisi.tdd.app.User;
import nl.avisi.tdd.app.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DatabaseUserRepository implements UserRepository {
    private final UserCrudRepository userCrudRepository;

    public DatabaseUserRepository(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public void save(User user) {
        UserEntity entity = new UserEntity();
        entity.username = user.getUsername();
        entity.passwordHash = user.getPasswordHash().getValue();
        userCrudRepository.save(entity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserEntity> userDTO = userCrudRepository.findByUsername(username);
        return userDTO.map(dto -> new User(dto.username, new SHA256Hash(dto.passwordHash)));
    }
}
