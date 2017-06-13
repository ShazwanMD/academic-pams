package my.edu.umk.pams.academic.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableWebSecurity
@EnableScheduling
@EnableBatchProcessing
@EnableTransactionManagement
@EnableCaching
@ComponentScan(basePackages = {
        // internals
        "my.edu.umk.pams.academic.identity",
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
        DatasourceConfig.class,
        SecurityConfig.class,
        AccessConfig.class,
        WorkflowConfig.class,
        CacheConfig.class,
        SwaggerConfig.class,
//        EmailConfig.class,
//        VelocityConfig.class,
//        ThreadingConfig.class,
})
@PropertySource("classpath:application.properties")
public class AppConfiguration {
}
