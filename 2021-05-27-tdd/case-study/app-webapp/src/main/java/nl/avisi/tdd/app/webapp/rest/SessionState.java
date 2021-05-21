package nl.avisi.tdd.app.webapp.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionState {
    private boolean authenticated = false;
    private String authenticateUsername = "";

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getAuthenticateUsername() {
        return authenticateUsername;
    }

    public void setAuthenticateUsername(String authenticateUsername) {
        this.authenticateUsername = authenticateUsername;
    }
}
