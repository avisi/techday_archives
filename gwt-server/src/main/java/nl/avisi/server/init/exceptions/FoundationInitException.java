package nl.avisi.foundation.server.core.init.exceptions;

public class FoundationInitException extends RuntimeException {

    private String reason;

    public FoundationInitException(String reason) {
        super(reason);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
