package ziyue.prey.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ziyue.prey.listeners.CsrfTokenIssuer;

@Configuration
public class Listeners {

    @Bean
    public ServletListenerRegistrationBean<CsrfTokenIssuer> csrfTokenIssuerServletListenerRegistrationBean() {
        ServletListenerRegistrationBean<CsrfTokenIssuer> registration = new ServletListenerRegistrationBean<>();
        registration.setListener(new CsrfTokenIssuer());
        return registration;
    }

}
