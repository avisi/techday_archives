package nl.avisi.server.services;

import nl.avisi.server.persistence.IdProvider;
import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.exceptions.NoSuchPizzaException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaService {

    private final IdProvider idProvider;
    private List<Pizza> pizzaList;

    @Autowired
    public PizzaService(IdProvider idProvider) {
        this.idProvider = idProvider;

        pizzaList = new ArrayList<Pizza>();
        Pizza pizza = new Pizza();
        pizza.setId(idProvider.getNextId());
        pizza.setName("Pizza Capresa");
        pizzaList.add(pizza);
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

        pizza.setId(idProvider.getNextId());
        return pizza;
    }

    public Pizza update(Pizza otherPizza) throws NoSuchPizzaException {
        for (Pizza pizza : pizzaList) {
            if (pizza.getId().equals(otherPizza.getId())) {
                pizzaList.remove(pizza);
                pizzaList.add(otherPizza);
                return otherPizza;
            }
        }
        throw new NoSuchPizzaException("No such pizza known on this server");
    }

}
