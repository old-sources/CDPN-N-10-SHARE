package fr.imie;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LanguageFilter
 */
@WebFilter("/*")
public class LanguageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LanguageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
//		String localeValue;
//		switch (httpRequest.getLocale().getLanguage()) {
//		case "US_EN":
//			localeValue="en"
//			break;
//
//		default:
//			break;
//		}
//		Enumeration<Locale> locales = httpRequest.getLocales();
//		for(Locale locale : Collections.list(locales)){
//			System.out.println(String.format(" locale %S,%S", locale.getLanguage(),locale.getCountry()));
//		}
		
		
		httpRequest.setAttribute("locale",httpRequest.getLocale().getLanguage().toLowerCase());
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
