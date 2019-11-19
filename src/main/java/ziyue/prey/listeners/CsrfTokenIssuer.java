package ziyue.prey.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.UUID;

public class CsrfTokenIssuer implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setAttribute("csrfToken", UUID.randomUUID().toString());
    }
}
