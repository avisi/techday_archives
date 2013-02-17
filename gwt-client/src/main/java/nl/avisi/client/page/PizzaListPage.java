package nl.avisi.client.page;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import nl.avisi.client.widget.PizzaListWidget;
import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.rest.PizzaResource;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
@Page(startingPage = true)
@Templated
public class PizzaListPage extends Composite {

    private final Caller<PizzaResource> pizzaResource;

    private final RootPanel rootPanel = RootPanel.get();

    private final PizzaListWidget pizzaListWidget;

    @Inject
    public PizzaListPage(Caller<PizzaResource> pizzaResource, PizzaListWidget pizzaListWidget) {
        this.pizzaResource = pizzaResource;
        this.pizzaListWidget = pizzaListWidget;
        rootPanel.add(pizzaListWidget);
    }

    @PostConstruct
    public void init() {
    pizzaResource.call(new RemoteCallback<List<Pizza>>() {
        @Override
        public void callback(List<Pizza> pizzas) {
            pizzaListWidget.setItems(pizzas);
        }
    }).list();
    }
}
