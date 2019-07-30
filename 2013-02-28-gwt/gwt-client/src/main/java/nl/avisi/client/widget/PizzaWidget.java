package nl.avisi.client.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;
import nl.avisi.shared.domain.Pizza;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.enterprise.context.Dependent;

@Dependent
@Templated
public class PizzaWidget extends Composite implements HasModel<Pizza> {

    @DataField
    private Element pizzaName = DOM.createSpan();

    @DataField
    private Element pizzaId = DOM.createSpan();

    private Pizza pizza;

//    private DataBinder<Pizza> pizzaBinder;
//
//    @Inject
//    public PizzaWidget(@AutoBound DataBinder<Pizza> pizzaBinder) {
//        super();
//        this.pizzaBinder = pizzaBinder;
//    }

    @Override
    public Pizza getModel() {
        return pizza;
    }

    @Override
    public void setModel(Pizza model) {
        this.pizza = pizza;
        pizzaName.setInnerText(model.getName());
        pizzaId.setInnerText(String.valueOf(model.getId()));
    }
}
