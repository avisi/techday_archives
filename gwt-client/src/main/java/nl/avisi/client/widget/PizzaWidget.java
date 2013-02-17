package nl.avisi.client.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;
import nl.avisi.shared.domain.Pizza;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.databinding.client.api.InitialState;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@Templated
public class PizzaWidget extends Composite implements HasModel<Pizza> {

    @Bound
    @DataField
    private Element name = DOM.createSpan();

    @Bound
    @DataField
    private Element id = DOM.createSpan();

    private DataBinder<Pizza> pizzaBinder;

    @Inject
    public PizzaWidget(@AutoBound DataBinder<Pizza> pizzaBinder) {
        this.pizzaBinder = pizzaBinder;
    }

    @Override
    public Pizza getModel() {
        return pizzaBinder.getModel();
    }

    @Override
    public void setModel(Pizza model) {
        pizzaBinder.setModel(model, InitialState.FROM_MODEL);
    }
}
