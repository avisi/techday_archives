package nl.avisi.tdd.app;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SHA256Hash {
    private final byte[] hash;

    private SHA256Hash(byte[] hash) {
        this.hash = hash;
    }

    public static SHA256Hash createFromUTF8String(String string) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return new SHA256Hash(digest.digest(string.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SHA256Hash that = (SHA256Hash) o;
        return Arrays.equals(hash, that.hash);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(hash);
    }
}
