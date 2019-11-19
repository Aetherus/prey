package ziyue.prey.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import java.util.Collections;

@Configuration
public class ServletContext implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
    }
}
