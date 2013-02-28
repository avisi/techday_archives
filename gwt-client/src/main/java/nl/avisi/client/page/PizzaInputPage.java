package nl.avisi.client.page;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import nl.avisi.shared.domain.Pizza;
import nl.avisi.shared.rest.PizzaResource;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ioc.client.api.Caller;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.*;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Page(path = "new")
@Dependent
@Templated
public class PizzaInputPage extends Composite {

    @Inject
    @DataField
    private final Button savePizza;

    @Inject
    @Bound
    @DataField
    private TextBox name;

    @Inject
    private final TransitionTo<PizzaListPage> transitionToPizzaListPage;

    private final DataBinder<Pizza> pizzaBinder;

    private final Caller<PizzaResource> pizzaResourceCaller;

    @Inject
    public PizzaInputPage(Button savePizza, TransitionTo<PizzaListPage> transitionToPizzaListPage,
                          @AutoBound DataBinder<Pizza> pizzaBinder, Caller<PizzaResource> pizzaResourceCaller) {
        this.savePizza = savePizza;
        this.pizzaResourceCaller = pizzaResourceCaller;
        this.transitionToPizzaListPage = transitionToPizzaListPage;
        this.pizzaBinder = pizzaBinder;
    }

    @EventHandler("savePizza")
    public void gotoNewPizzaPage(ClickEvent e) {
        pizzaResourceCaller.call(new RemoteCallback<Pizza>() {
            @Override
            public void callback(Pizza o) {
                transitionToPizzaListPage.go();
            }
        }).save(pizzaBinder.getModel());
        // TODO errorhandling
    }


}
