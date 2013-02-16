package nl.avisi.client;

import com.google.gwt.user.client.Window;
import org.jboss.errai.ioc.client.api.EntryPoint;

import javax.annotation.PostConstruct;

@EntryPoint
public class Application{

    @PostConstruct
    public void init() {
        Window.alert("Hallo!!!");
    }
}
