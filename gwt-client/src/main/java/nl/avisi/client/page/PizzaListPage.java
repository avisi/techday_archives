package nl.avisi.client.page;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import nl.avisi.client.widget.PizzaListWidget;
import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.rest.PizzaResource;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.ioc.client.api.Caller;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
@Page(startingPage = true, path = "index")
@Templated
public class PizzaListPage extends Composite {

    private final Caller<PizzaResource> pizzaResource;

    private final RootPanel rootPanel = RootPanel.get();

    private final PizzaListWidget pizzaListWidget;

    @DataField
    private HTMLPanel pizzaContainer = new HTMLPanel("div", "");

    @Inject
    @DataField("newPizzaLink")
    private Button newPizzaLink;

    private final TransitionTo<PizzaInputPage> transitionToNewPizza;

    @Inject
    public PizzaListPage(Caller<PizzaResource> pizzaResource, PizzaListWidget pizzaListWidget, TransitionTo<PizzaInputPage> transitionToNewPizza) {
        this.pizzaResource = pizzaResource;
        this.pizzaListWidget = pizzaListWidget;
        this.transitionToNewPizza = transitionToNewPizza;
        pizzaContainer.add(pizzaListWidget);
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

    @EventHandler("newPizzaLink")
    public void gotoNewPizzaPage(ClickEvent e) {
        transitionToNewPizza.go();
    }
}
