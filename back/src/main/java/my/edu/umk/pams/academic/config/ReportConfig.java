package my.edu.umk.pams.academic.config;

import my.edu.umk.pams.academic.web.module.report.JasperServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 */
@Configuration
public class ReportConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(jasperServlet(), "/servlet/report");
    }

    @Bean
    public Servlet jasperServlet(){
        return new JasperServlet();
    }
}
