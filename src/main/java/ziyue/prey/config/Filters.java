package ziyue.prey.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ziyue.prey.filters.RequestMethodOverrideFilter;

@Configuration
public class Filters {

    @Bean
    public FilterRegistrationBean<RequestMethodOverrideFilter> requestMethodOverrideFilterFilterRegistrationBean() {
        FilterRegistrationBean<RequestMethodOverrideFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RequestMethodOverrideFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}
