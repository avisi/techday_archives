package nl.avisi.server.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class CoreInitializer implements WebApplicationInitializer {

    /**
     * Bootstrap the application
     */
    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setServletContext(servletContext);
        rootContext.scan("nl.avisi.server", "nl.avisi.shared");

        servletContext.addListener(new ContextLoaderListener(rootContext));

        final ServletRegistration.Dynamic servlet = servletContext.addServlet("spring", new DispatcherServlet(rootContext));

        servletContext.addListener(new RequestContextListener());

//        FilterRegistration.Dynamic localFilterRegistration = servletContext.addFilter("localeFilter", LocaleFilter.class);
//        localFilterRegistration.setInitParameter("localeFilter.defaultLocale", "en");
//        localFilterRegistration.setInitParameter("localeFilter.availableLocales", "en,nl");
//        localFilterRegistration.addMappingForUrlPatterns(null, false, "/*");

//        servletContext.addFilter("corsFilter", CorsFilter.class)
//                .addMappingForUrlPatterns(null, false, "/*");

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");
    }
}
