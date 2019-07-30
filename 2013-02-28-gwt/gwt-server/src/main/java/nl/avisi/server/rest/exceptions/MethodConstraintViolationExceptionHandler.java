package nl.avisi.server.rest.exceptions;

import nl.avisi.server.rest.RestError;

import org.hibernate.validator.engine.PathImpl;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Provider
@Component
public class MethodConstraintViolationExceptionHandler implements ExceptionMapper<MethodConstraintViolationException> {

    @Override
    public Response toResponse(MethodConstraintViolationException ex) {
        Set<MethodConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<String> violationMessages = new ArrayList<String>();

        for (MethodConstraintViolation<?> violation : violations) {
            String name = ((PathImpl)violation.getPropertyPath()).getLeafNode().getName();
            String message = violation.getMessage();
            violationMessages.add(name + " " + message);
        }

        RestError restError = new RestError(1L, violationMessages);
        return Response.status(Response.Status.BAD_REQUEST).entity(restError).build();
    }

}