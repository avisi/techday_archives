package nl.avisi.shared.rest;

import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.exceptions.NoSuchPizzaException;

import org.jboss.resteasy.spi.validation.ValidateRequest;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("pizzas")
@ValidateRequest
public interface PizzaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Pizza> list();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Pizza save(@Valid(grou) Pizza pizza);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Pizza update(@Valid Pizza pizza) throws NoSuchPizzaException;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void delete(@Valid Pizza pizza);
}
