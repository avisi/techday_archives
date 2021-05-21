package nl.avisi.tdd.app;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SHA256Hash {
    private final byte[] value;

    public SHA256Hash(byte[] value) {
        this.value = value;
    }

    public static SHA256Hash createFromUTF8String(String string) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return new SHA256Hash(digest.digest(string.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public byte[] getValue() {
        return value;
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
        return Arrays.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }
}
