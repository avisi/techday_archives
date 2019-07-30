package nl.avisi.client.validation;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

import nl.avisi.shared.domain.Pizza;

import javax.validation.Validator;


public class CustomValidationFactory extends AbstractGwtValidatorFactory {

    @GwtValidation(Pizza.class)
    public interface GwtValidator extends Validator {
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }
}
