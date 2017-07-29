package my.edu.umk.pams.academic.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tngtech.jgiven.integration.spring.EnableJGiven;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@TestConfiguration
@EnableJGiven
@EnableWebSecurity
@EnableScheduling
@EnableBatchProcessing
@EnableJms
//@EnableIntegration
@EnableTransactionManagement
@EnableCaching
@ComponentScan(basePackages = {

        // testing
        "my.edu.umk.pams.bdd.stage",

        // internals
        "my.edu.umk.pams.academic.identity",
        "my.edu.umk.pams.academic.assessment",
        "my.edu.umk.pams.academic.graduation",
        "my.edu.umk.pams.academic.security",
        "my.edu.umk.pams.academic.system",
        "my.edu.umk.pams.academic.workflow",

        // modules
        "my.edu.umk.pams.academic.common",
        "my.edu.umk.pams.academic.profile",
        "my.edu.umk.pams.academic.planner",
        "my.edu.umk.pams.academic.term",
        "my.edu.umk.pams.academic.graduation",

        // web modules
        "my.edu.umk.pams.academic.web.module.identity",
        "my.edu.umk.pams.academic.web.module.common",
        "my.edu.umk.pams.academic.web.module.profile",
        "my.edu.umk.pams.academic.web.module.planner",
        "my.edu.umk.pams.academic.web.module.term",
        "my.edu.umk.pams.academic.web.module.graduation",
}
)
@Import({
        TestDatasourceConfig.class,
        TestSecurityConfig.class,
        TestWorkflowConfig.class,
        TestAccessConfig.class,
        TestCacheConfig.class,
        TestEmailConfig.class,
        TestJmsConfig.class,
        TestIntegrationConfig.class,
})
@PropertySource("classpath:application.properties")
public class TestAppConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public String configureJGivenReportPlainText() {
        final String key = "jgiven.report.text";
        final String value = env.getProperty(key) == null ? "true" : env.getProperty(key);
        return System.setProperty(key, value);
    }

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        return builder;
    }

}
