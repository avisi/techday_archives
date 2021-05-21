package nl.avisi.tdd.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRegistrationTest {
    private Fixture fixture;

    @BeforeEach
    void setUp() {
        fixture = new Fixture();
    }

    @Test
    public void registerNewUser() {
        fixture.registerNewUser("alice", "password");

        boolean authenticated = fixture.authenticate("alice", "password");

        assertTrue(authenticated);
    }

    @Test
    public void authenticateWithoutRegistering() {
        boolean authenticated = fixture.authenticate("alice", "password");

        assertFalse(authenticated);
    }

    @Test
    public void authenticateWithInvalidPassword() {
        fixture.registerNewUser("alice", "password");

        boolean authenticated = fixture.authenticate("alice", "invalid");

        assertFalse(authenticated);
    }
}
