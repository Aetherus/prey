package ziyue.prey.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CsrfProtectionFilter extends HttpFilter {

    private static final List<String> UNPROTECTED_METHODS = Arrays.asList("GET", "HEAD", "OPTIONS");

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (UNPROTECTED_METHODS.contains(request.getMethod())) {
            chain.doFilter(request, response);
        } else {
            String csrfTokenFromSession = (String) request.getSession().getAttribute("csrfToken");
            String csrfTokenFromRequest = request.getParameter("_csrfToken");
            if (csrfTokenFromRequest == null) {
                csrfTokenFromRequest = request.getHeader("X-Csrf-Token");
            }
            if (csrfTokenFromSession.equals(csrfTokenFromRequest)) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("/error.html");
            }
        }
    }
}
