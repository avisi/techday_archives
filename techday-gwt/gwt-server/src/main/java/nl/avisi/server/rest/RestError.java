package nl.avisi.server.rest;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@JsonSerialize
public class RestError {

    private final Long status;
    private List<String> violationMessages;

    public RestError(Long status, List<String> violationMessages) {
        this.status = status;
        this.violationMessages = violationMessages;
    }

    public Long getStatus() {
        return status;
    }

    public List<String> getViolationMessages() {
        return violationMessages;
    }
}
