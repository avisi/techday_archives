package nl.avisi.client;

import com.google.gwt.user.client.ui.RootPanel;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@EntryPoint
public class Application {

    @Inject
    private Navigation navigation;

    @Inject
    private RootPanel rootPanel;

    @PostConstruct
    public void init() {
        rootPanel.get().add(navigation.getContentPanel().asWidget());
    }
}
