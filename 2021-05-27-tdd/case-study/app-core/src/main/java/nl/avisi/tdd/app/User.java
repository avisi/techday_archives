package nl.avisi.tdd.app;

public class User {
    private final String username;
    private final SHA256Hash passwordHash;

    public User(String username, SHA256Hash passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public static User createWithPassword(String username, String password) {
        SHA256Hash passwordHash = SHA256Hash.createFromUTF8String(password);
        return new User(username, passwordHash);
    }

    public String getUsername() {
        return username;
    }

    public SHA256Hash getPasswordHash() {
        return passwordHash;
    }

    public boolean authenticate(String password) {
        return this.passwordHash.equals(SHA256Hash.createFromUTF8String(password));
    }
}
