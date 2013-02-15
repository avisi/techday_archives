package nl.avisi.server.init;

import com.google.common.collect.Lists;

import nl.avisi.server.init.i18n.I18nResource;
import nl.avisi.server.init.locale.FilterLocaleResolver;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
public class CoreConfigurer extends WebMvcConfigurerAdapter {

    public static final int CACHE_SECONDS_MESSAGE_SOURCE = 3600;

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/App/**").addResourceLocations("classpath:/gwt/App/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/");
    }

    /**
     * Supports Json Marshalling
     */
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJacksonHttpMessageConverter());
        converters.add(new FormHttpMessageConverter());
        converters.add(new ByteArrayHttpMessageConverter());
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new FilterLocaleResolver();
    }

    @Bean
    public MessageSource messageSource(List<I18nResource> resources) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setAlwaysUseMessageFormat(true);
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(CACHE_SECONDS_MESSAGE_SOURCE);
        if (resources != null) {
            List<String> baseNames = Lists.newArrayList();
            for (I18nResource resource : resources) {
                baseNames.addAll(resource.getResources());
            }
            messageSource.setBasenames(baseNames.toArray(new String[baseNames.size()]));
        }
        return messageSource;
    }
}
