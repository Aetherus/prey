package ziyue.prey.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class RequestMethodOverrideFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        final String mask = request.getParameter("_method");
        if (StringUtils.isEmpty(mask)) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(new HttpServletRequestWrapper(request) {
                @Override
                public String getMethod() {
                    return mask.toUpperCase();
                }
            }, response);
        }
    }
}
