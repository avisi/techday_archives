package nl.avisi.server.init.i18n;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoreI18nResource implements I18nResource {
    
    @Override
    public List<String> getResources() {
        return Lists.newArrayList(
                "classpath:i18n/application"
        );
    }
    
}
