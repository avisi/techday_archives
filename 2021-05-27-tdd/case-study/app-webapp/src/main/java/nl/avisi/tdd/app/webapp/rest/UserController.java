package nl.avisi.tdd.app.webapp.rest;

import nl.avisi.tdd.app.AuthenticationService;
import nl.avisi.tdd.app.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/rest/user")
public class UserController {
    private final UserRegistrationService userRegistrationService;
    private final AuthenticationService authenticationService;
    private final SessionState sessionState;

    public UserController(UserRegistrationService userRegistrationService, AuthenticationService authenticationService, SessionState sessionState) {
        this.userRegistrationService = userRegistrationService;
        this.authenticationService = authenticationService;
        this.sessionState = sessionState;
    }

    @PostMapping("register")
    public void register(@RequestParam String username, @RequestParam String password) {
        userRegistrationService.registerNewUser(username, password);
    }

    @PostMapping("authenticate")
    public void authenticate(@RequestParam String username, @RequestParam String password) {
        if (!authenticationService.authenticate(username, password)) {
            sessionState.setAuthenticated(false);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        sessionState.setAuthenticated(true);
        sessionState.setAuthenticateUsername(username);
    }

    @GetMapping("whoami")
    public String whoami() {
        if (!sessionState.isAuthenticated()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return sessionState.getAuthenticateUsername();
    }
}
