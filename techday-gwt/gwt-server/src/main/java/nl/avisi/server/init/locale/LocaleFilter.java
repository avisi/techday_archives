package nl.avisi.server.init.locale;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LocaleFilter implements Filter {

    private String defaultLocale;
    private String[] availableLocales;

    private List<String> getServletRequestParts(ServletRequest request) {
        String[] splicedParts = ((HttpServletRequest) request).getPathInfo().split("/");
        List<String> result = new ArrayList<String>();

        for (int i = 1; i < splicedParts.length; i++) {
            String sp = splicedParts[i];
            if (sp.trim().length() > 0) {
                result.add(sp);
            }
        }

        return result;
    }

    private Locale getLocaleFromRequestParts(List<String> parts) {
        if (parts.size() > 0) {
            for (String lang : availableLocales) {
                if (lang.equals(parts.get(0))) {
                    return new Locale(lang);
                }
            }
        }

        return null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        availableLocales = filterConfig.getInitParameter("localeFilter.availableLocales").split(",");
        defaultLocale = filterConfig.getInitParameter("localeFilter.defaultLocale");
        System.out.println();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        List<String> requestParts = this.getServletRequestParts(request);
        Locale locale = this.getLocaleFromRequestParts(requestParts);

        if (locale != null) {
            request.setAttribute(LocaleFilter.class.getName() + ".LOCALE", locale);

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < requestParts.size(); i++) {
                sb.append('/');
                sb.append(requestParts.get(i));
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(sb.toString());

            dispatcher.forward(request, response);
        } else {
            request.setAttribute(LocaleFilter.class.getName() + ".LOCALE", new Locale(defaultLocale));
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}