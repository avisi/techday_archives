package nl.avisi.server.services;

import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.exceptions.NoSuchPizzaException;

import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaService {

    private List<Pizza> pizzaList;

    public PizzaService() {
        pizzaList = new ArrayList<Pizza>();
        pizzaList.add(new Pizza(0l, "Calzone pizza"));
    }

    public void deletePizzaById(@Nonnull Long id) {
        for (Pizza pizza : pizzaList) {
            if (pizza.getId().equals(id)) {
                pizzaList.remove(pizza);
                return;
            }
        }
    }

    public List<Pizza> all() {
        return pizzaList;
    }

    public Pizza create(Pizza pizza) {
        pizzaList.add(pizza);
        return pizza;
    }

    public Pizza update(Pizza otherPizza) throws NoSuchPizzaException {
        for (Pizza pizza : pizzaList) {
            if (pizza.getId().equals(otherPizza.getId())) {
                pizzaList.remove(pizza);
                Pizza createdPizza = new Pizza(pizza.getId(), otherPizza.getName());
                pizzaList.add(createdPizza);
                return createdPizza;
            }
        }
        throw new NoSuchPizzaException("No such pizza known on this server");
    }
}
