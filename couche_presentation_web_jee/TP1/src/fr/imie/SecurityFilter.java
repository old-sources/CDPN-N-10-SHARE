package fr.imie;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		UserEntity connectedUser = (UserEntity) httpRequest.getSession().getAttribute("connectedUser");
		if (connectedUser == null && !httpRequest.getRequestURI().contains("login")) {
			String redirectUrl = httpRequest.getRequestURI();
			if(httpRequest.getQueryString()!=null){
				redirectUrl = redirectUrl .concat("?").concat(httpRequest.getQueryString());
			}
			httpRequest.getSession().setAttribute("redirectUrl", redirectUrl);
			httpResponse.sendRedirect("login");
		} else {

			// pass the request along the filter chain
			chain.doFilter(request, response);

			UserEntity newConnectedUser = (UserEntity) httpRequest.getSession().getAttribute("connectedUser");
			if (connectedUser == null && newConnectedUser != null) {
				String redirectUrl = (String) httpRequest.getSession().getAttribute("redirectUrl");
				if(redirectUrl==null){
					httpResponse.sendRedirect("projects");
				}else{
					httpResponse.sendRedirect((String) httpRequest.getSession().getAttribute("redirectUrl"));
				}
				httpRequest.getSession().removeAttribute("redirectUrl");
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
