package ziyue.prey.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import ziyue.prey.filters.CsrfProtectionFilter;
import ziyue.prey.filters.RequestMethodOverrideFilter;

@Configuration
public class Filters {

    @Bean
    @Order(1)
    public FilterRegistrationBean<RequestMethodOverrideFilter> requestMethodOverrideFilterFilterRegistrationBean() {
        FilterRegistrationBean<RequestMethodOverrideFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RequestMethodOverrideFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    @Order(2)
    public FilterRegistrationBean<CsrfProtectionFilter> csrfProtectionFilterFilterRegistrationBean() {
        FilterRegistrationBean<CsrfProtectionFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CsrfProtectionFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
}
