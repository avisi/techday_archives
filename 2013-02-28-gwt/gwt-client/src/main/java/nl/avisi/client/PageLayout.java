package nl.avisi.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Singleton;

@Templated
@Singleton
public class PageLayout extends Composite {

    @DataField
    public HTMLPanel container = new HTMLPanel("div", "");

    public HTMLPanel getContainer() {
        return container;
    }
}
