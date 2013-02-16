package nl.avisi.server.rest;

import nl.avisi.server.services.PizzaService;
import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.exceptions.NoSuchPizzaException;
import nl.avisi.shared.rest.PizzaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultPizzaResource implements PizzaResource {

    private final PizzaService pizzaService;

    @Autowired
    public DefaultPizzaResource(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Override
    public List<Pizza> list() {
        return pizzaService.all();
    }

    @Override
    public Pizza save(Pizza pizza) {
        return pizzaService.create(pizza);
    }

    @Override
    public Pizza update(Pizza pizza) throws NoSuchPizzaException {
        return pizzaService.update(pizza);
    }

    @Override
    public void delete(Pizza pizza) {
        pizzaService.deletePizzaById(pizza.getId());
    }
}
