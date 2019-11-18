package ziyue.prey.interceptors;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ziyue.prey.annotations.SkipAuthentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) return true;
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        boolean skipAuthentication = handlerMethod.getMethodAnnotation(SkipAuthentication.class) != null;
        if (skipAuthentication) return true;
        if (request.getSession().getAttribute("currentUser") != null) return true;
        response.sendRedirect("/sessions/new");
        return false;
    }
}
