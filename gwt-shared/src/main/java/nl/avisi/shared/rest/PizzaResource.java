package nl.avisi.shared.rest;

import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.exceptions.NoSuchPizzaException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("pizzas")
public interface PizzaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Pizza> list();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Pizza save(Pizza pizza);

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Pizza update(Pizza pizza) throws NoSuchPizzaException;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void delete(Pizza pizza);
}
